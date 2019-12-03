package java8inaction.lambdaexpression;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author KangShan
 * @date 2019/11/19 2:02
 */
public class FunctionalInterfaceTest {
//    void test(FunctionalInterface i){
//        System.out.println(i.test());
//    }
    boolean no = false;
//    static boolean yes = true;

    void greet(){
//        System.out.println("greet..");
    }

    FunctionalInterfaceTest (int i, String j, Object o){
        this.no = i < 0;
    }

    void print(int i){
//        Arrays.asList(new FunctionalInterfaceTest())
//                .forEach(FunctionalInterfaceTest::greet);
    }

    static void setI(FunctionalInterfaceTest i){
        i.no = true;
    }

    public static void main(String[] args) {
        FunctionalInterface t = FunctionalInterfaceTest::new;
        /**
         * 只要有且仅有一个抽象方法即可使用 lambda expression instead the implement
         */
//        FunctionalInterfaceTest t = new FunctionalInterfaceTest();
//        Boolean  yesOrNo = Boolean.FALSE;
//        Object                  o = new Object();
//        Integer j = 4342;
//        System.out.println(t.no);
//        setI(t);
//        System.out.println(t.no);
//        System.out.println();
//        t.test(() -> {
//            if(43/4 > 3){
//                yes = false;
//                t.no = false;
//            }else {
//                yes = true;
//            }
//            return yes;
//        });

    }
}
