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

    public StreamForker<T> fork(Object key, Function<Stream<T>, ?> function) {
        this.forks.put(key, function);
        return this;
    }

    /**
     * 将 stream 中元素 copy 到各个 iterator.BlockingQueue 中，再使用 StreamSupport.stream 造出新的
     * Stream 来，分别对 stream 进行运算即可。
     * 这样操作对于一般的 {@link Collection}使用与调用 {@link Collection#stream()}并无二致，且增加代码量。
     *      所以对于 {@link Collection} 不推荐使用此类操作进行 fork Stream。
     * 那么此类方法适用的情形：对于计算机内的本地文件流的多样操作
     *      如果需要读取非RAM内存中的数据，如果使用 {@link java.io.InputStream} 多次读取会浪费资源，
     *      待研究
     * @return  java8inaction.stream.muiltipleoperate.StreamForker.Results
     * @date    2020/1/3 17:13
     */
    public Results getResults() {
        ForkingStreamConsumer<T> consumer = build();
        //将 stream 中各个元素 copy 到 spliterator.BlockingQueue 中
        stream.sequential().forEach(consumer);
        //在各个 BlockingQueue 尾部加上 end flag
        consumer.finish();
        return consumer;
    }

    /**
     *
     * @return  java8inaction.stream.muiltipleoperate.StreamForker.ForkingStreamConsumer<T>
     * @date    2020/1/3 16:25
     */
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

    /**
     * 异步执行各个 consumer
     * @param   queues 阻塞队列集合
     * @param   function steam consumer
     * @return  执行结果 future
     * @date    2020/1/3 16:11
     */
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
