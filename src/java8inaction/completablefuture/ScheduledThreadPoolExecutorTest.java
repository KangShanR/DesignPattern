package java8inaction.completablefuture;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author KangShan
 * @date 2019/12/19 18:45
 */
public class ScheduledThreadPoolExecutorTest {
    static void fixedDelayTest() {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(10,
                r -> {
                    Thread thread = new Thread(r);
                    System.out.println("new Thread : " + thread.getName() );
                    return thread;
                });

        pool.scheduleWithFixedDelay(() -> {
                    System.out.println(
                            "scheculed tast time:" + LocalDateTime.now() +
                                    "; Thread:" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                5, 2, TimeUnit.SECONDS);
    }

    static void fixedRateTest() {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(10,
                r -> {
                    Thread thread = new Thread(r);
                    System.out.println("new Thread : " + thread.getName() );
                    return thread;
                });

        pool.scheduleAtFixedRate(() -> {
                    System.out.println(
                            "scheculed tast time:" + LocalDateTime.now() +
                                    "; Thread:" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                5, 2, TimeUnit.SECONDS);
    }


    public static void main(String[] args) {
//        fixedDelayTest();
        fixedRateTest();
    }
}
