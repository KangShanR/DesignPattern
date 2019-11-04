package thinking_in_java.thread;

/**
 * @author KangShan
 * @date 2019/8/1 15:59
 */
public class ThreadTest {

    synchronized void test1() {
        System.out.println("test1 start");
        try {
            System.out.println("test1 execute");
            Thread thread = Thread.currentThread();
            System.out.println("thread name : " + thread.getName());
            System.out.println("priority : " + thread.getPriority());
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test1 end");
    }

    synchronized void test2() {
        System.out.println("test2 start");
        try {
            Thread thread = Thread.currentThread();
            System.out.println("thread name : " + thread.getName());
            System.out.println("priority : " + thread.getPriority());
            System.out.println("test2 execute");
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test2 end");
    }


    public static void main(String[] args){
        Thread           thread = Thread.currentThread();
        System.out.println("main thread priority : " + thread.getPriority());
        System.out.println("main thread name : " + thread.getName());
        final ThreadTest t0 = new ThreadTest();
        final ThreadTest t1 = new ThreadTest();

        System.out.println("start 2");
        new Thread(() -> t1.test1()).start();

        System.out.println("start 1");
        new Thread(() -> t0.test2()).start();



    }
}
