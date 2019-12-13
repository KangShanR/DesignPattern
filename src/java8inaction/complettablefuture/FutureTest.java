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
                throw new RuntimeException("exception");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        System.out.println("wait");
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        pool.shutdown();
    }

    static void threadPoolExecutorTest() {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1,
                r -> {
                    System.out.println("new Thread Factory");
                    return new Thread(r);
                });
    }

    static void completableFutureTest() {
        CompletableFuture<String> good = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("good");
        });
        try {
            String o = good.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static Future<String> getF() {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(()-> {
            String str = null;
            future.complete((String) str.concat("d"));
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
