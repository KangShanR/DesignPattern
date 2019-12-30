package java8inaction.stream.muiltipleoperate;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * fork the streams
 *
 * @author KangShan
 * @date 2019/12/26 1:23
 */
public class StreamForker<T> {
    private final Stream<T>                           stream;
    private final Map<Object, Function<Stream<T>, ?>> forks = new HashMap<>(16);

    public StreamForker(Stream<T> stream) {
        this.stream = stream;
    }

    public StreamForker fork(Object key, Function<Stream<T>, ?> function) {
        this.forks.put(key, function);
        return this;
    }

    public Results getResults() {
        ForkingStreamConsumer<T> consumer = build();
        try {
            stream.sequential().forEach(consumer);
        }finally {
            consumer.finish();
        }
        return consumer;
    }

    public ForkingStreamConsumer<T> build() {
        List<BlockingQueue<T>> queues = new ArrayList<>();
        Map<Object, Future<?>> actions =
                               forks.entrySet().stream().reduce(
                                       new HashMap<Object, Future<?>>(16),
                                       (map, e) -> {map.put(e.getKey(),
                                               getOperationResult(queues, e.getValue()));
                                       return map;},
                                       (m1, m2) -> {m1.putAll(m2); return m1;}
                               );
        return new ForkingStreamConsumer<>(queues, actions);
    }

    private Future<?> getOperationResult(List<BlockingQueue<T>> queues,
                                         Function<Stream<T>, ?> function) {
        LinkedBlockingQueue<T> queue = new LinkedBlockingQueue<>();
        queues.add(queue);
        Spliterator<T> spliterator = new BlockingQueueSpliterator<>(queue);
        Stream<T>      source      = StreamSupport.stream(spliterator, false);
        return CompletableFuture.supplyAsync(() -> function.apply(source));
    }

    interface Results{
        /**
         * 获取计算结果
         * @param   key 键
         * @return  R
         * @date    2019/12/27 12:03
         */
        <R> R get(Object key);
    }

    static class ForkingStreamConsumer<T> implements Consumer<T>, Results {
        static final Object                  STREAM_END = new Object();
        private final List<BlockingQueue<T>> queues;
        private final Map<Object, Future<?>> actions;

        ForkingStreamConsumer(List<BlockingQueue<T>> queues, Map<Object, Future<?>> actions) {
            this.queues = queues;
            this.actions = actions;
        }
        @Override
        public void accept(T t) {
            queues.forEach(q -> q.add(t));
        }

        @Override
        public <R> R get(Object key) {
            try{
                return ((Future<R>) actions.get(key)).get();
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        void finish() {
            accept((T)STREAM_END);
        }
    }


}
