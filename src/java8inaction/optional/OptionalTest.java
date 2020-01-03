package java8inaction.optional;

import java.lang.invoke.LambdaMetafactory;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author KangShan
 * @date 2019/12/10 23:54
 */
public class OptionalTest {

    Function<Integer, String> f = (Integer i) -> i.toString();
    Consumer<Integer> c = (Integer i) -> {};

    void test(String s) {

    }

//    public static void main(String[] args) {
//        System.out.println(Optional.of(1)
//                .map(String::valueOf)
//                .map(Integer::new)
//                .flatMap(Optional::of)
//                .flatMap(Optional::ofNullable)
//                .get() == 1);
//    }
}
