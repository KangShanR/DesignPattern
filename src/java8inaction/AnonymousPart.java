package java8inaction;

/**
 * @author KangShan
 * @date 2019/11/16 21:43
 */
public class AnonymousPart {
    final int value = 10;
    void doIt(){
        int value = 6;
        Runnable runnable = new Runnable() {
            final int value = 5;
            @Override
            public void run() {
                int value = 4;
                System.out.println(this.value);
            }
        };
        runnable.run();
    }
    public static void main(String[] args) {
        System.out.println((String) new Object());
//        new AnonymousPart().doIt();
    }
}
