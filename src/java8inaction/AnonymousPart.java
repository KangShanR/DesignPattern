package java8inaction;

/**
 * @author KangShan
 * @date 2019/11/16 21:43
 */
public class AnonymousPart {
    final int value = 10;
    void doIt(){
        int value = 6;
        /**
         * 实现一个 Runnable 并没有创建线程（创建线程要用 Thread），
         * 这儿能跑起来是在 main 方法中调用的原因
         */
        Runnable runnable = () -> {
            final int value1 = 5;
            System.out.println(value1);
        };
        runnable.run();
    }
    public static void main(String[] args) {
        System.out.println((String) new Object());
//        new AnonymousPart().doIt();
    }
}
