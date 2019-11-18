package java8inaction.lambdaexpression;

/**
 * @author KangShan
 * @date 2019/11/19 2:02
 */
public class FunctionalInterfaceTest {
    void test(FunctionalInterface i){
        System.out.println(i.test());
    }

    public static void main(String[] args) {
        /**
         * 只要有且仅有一个抽象方法即可使用 lambda expression instead the implement
         */
        new FunctionalInterfaceTest().test(() -> true);
    }
}
