package java8inaction.complettablefuture;

import java.util.concurrent.*;

/**
 * @author KangShan
 * @date 2019/12/12 17:57
 */
public class FutureTest {

    static void executorServiceTest() {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<Integer> future         = pool.submit(() -> {
            try {
                Thread.sleep(2900);
//                throw new RuntimeException("exception");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        System.out.println("wait");
        try {
            System.out.println(future.get(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        pool.shutdown();
    }

    static void threadPoolExecutorTest() {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1,
                r -> {
                    System.out.println("new Thread Factory");
                    return new Thread(r);
                });
    }

    /**
     * 工厂方法使用将内部线程的异常直接抛出了，减少很多代码。
     * @author  KangShan
     * @return  void
     * @date    2019/12/14 0:59
     */
    static void completableFutureTest() {
        CompletableFuture<String> good = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("good");
        });
        try {
            String o = good.get();
            String join = good.join();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * native completableFuture 原生的 Thread 会产生同样的超时问题：
     *      如果新生成的 线程执行过程中出现异常， get() 并不能对异常捕捉，外部 Thread 就会一直
     *      等待不能被结束回收
     * @author  KangShan
     * @return  java.util.concurrent.Future<java.lang.String>
     * @date    2019/12/14 0:57
     */
    static Future<String> getF() {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(()-> {
            String str = null;
            future.complete(str.concat("d"));
        }).start();
        return future;
    }

    public static void main(String[] args) {
//        ExecutorServiceTest();
//        completableFutureTest();
        executorServiceTest();
//        try {
//            System.out.println(getF().get(5, TimeUnit.SECONDS));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }
    }

}