package java8inaction.stream.muiltipleoperate;

import java.util.Spliterator;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

/**
 * 阻塞队列分割器
 *
 * @author KangShan
 * @date 2019/12/26 1:14
 */
public class BlockingQueueSpliterator<T> implements Spliterator<T> {
    private final BlockingQueue<T> queue;

    public BlockingQueueSpliterator(BlockingQueue<T> queue) {
        this.queue = queue;
    }
    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        T t;
        while (true) {
            try {
                t = queue.take();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!t.equals(StreamForker.ForkingStreamConsumer.STREAM_END)) {
            action.accept(t);
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<T> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("while");
            break;
        }
        System.out.println();
    }
}
