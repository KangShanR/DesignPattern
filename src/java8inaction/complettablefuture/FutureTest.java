package java8inaction.complettablefuture;

import java.util.concurrent.*;

/**
 * @author KangShan
 * @date 2019/12/12 17:57
 */
public class FutureTest {

    public static void main(String[] args) {
//        ThreadPoolExecutor
//        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1,
//                r -> {
//                    System.out.println("new Thread Factory");
//                    return new Thread(r);
//                });
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<Integer> future         = pool.submit(() -> {
            try {
                Thread.sleep(2900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        System.out.println("wait");
        try {
            System.out.println(future.get(3, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        pool.shutdown();
    }
}
