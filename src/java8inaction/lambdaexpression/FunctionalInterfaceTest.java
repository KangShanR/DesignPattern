package java8inaction.lambdaexpression;

import java.util.Arrays;

/**
 * @author KangShan
 * @date 2019/11/19 2:02
 */
public class FunctionalInterfaceTest {
//    void test(FunctionalInterface i){
//        System.out.println(i.test());
//    }
//    boolean no;
//    static boolean yes = true;

    void greet(){
//        System.out.println("greet..");
    }

    void print(int i){
        Arrays.asList(new FunctionalInterfaceTest())
                .forEach(FunctionalInterfaceTest::greet);
    }

//    public static void main(String[] args) {
//        /**
//         * 只要有且仅有一个抽象方法即可使用 lambda expression instead the implement
//         */
//        FunctionalInterfaceTest t = new FunctionalInterfaceTest();
//        Boolean  yesOrNo = Boolean.FALSE;
//        Object                  o = new Object();
//        t.test(() -> {
//            if(43/4 > 3){
//                yes = false;
//                t.no = false;
//            }else {
//                yes = true;
//            }
//            return yes;
//        });
//
//    }
}
