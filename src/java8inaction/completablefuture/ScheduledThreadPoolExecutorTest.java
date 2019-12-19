package java8inaction.completablefuture;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author KangShan
 * @date 2019/12/19 18:45
 */
public class ScheduledThreadPoolExecutorTest {
    /**
     * 测试固定延迟 schedule task, 与 fixedRate 不同在于其固定间隔时间只在执行完成后再开始计时 delay
     * @date    2019/12/19 19:10
     */
    static void fixedDelayTest() {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(10,
                r -> {
                    Thread thread = new Thread(r);
                    System.out.println("new Thread : " + thread.getName());
                    return thread;
                });

        pool.scheduleWithFixedDelay(() -> {
                    System.out.println(
                            "scheduled task time:" + LocalDateTime.now() +
                                    "; Thread:" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                5, 2, TimeUnit.SECONDS);
    }

    /**
     * 测试固定执行 scheduled task
     * 同时，只有当前一个任务执行完成后才会执行第二个任务，不管有没有达到后一次 task 的 fixed 时间。
     * 也就是在这种情况下， fixed rate 会失效
     * @date    2019/12/19 19:09
     */
    static void fixedRateTest() {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(10,
                r -> {
                    Thread thread = new Thread(r);
                    System.out.println("new Thread : " + thread.getName());
                    return thread;
                });

        pool.scheduleAtFixedRate(() -> {
                    System.out.println(
                            "scheduled task time:" + LocalDateTime.now() +
                                    "; Thread:" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(3000);
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
