package java8inaction.lambdaexpression;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionTestObject {
    static String s = "Obj";
    String concat(String str, int i){
        return s.concat(str);
    }


    static void print(BinaryOperator<Integer> operator) {
        Integer i = 3;
        Integer j =4;
        System.out.println(operator.apply(i,j));
    }

    public static void main(String[] args) {
        Consumer consumer = FunctionTestObject::concat;
        /**
         * 接口中静态方法的引用
         */
        print(BinaryOperator.minBy(Integer::compare));

        List<Integer> collect = IntStream.range(0, 100).parallel()
                .peek(i -> System.out.println("origin:" + i))
                .filter(i -> i > 5)
                .peek(i -> System.out.println("after filter: " + i))
                .filter(i -> i < 9)
                .peek(i -> System.out.println("after 2ed filter: " + i))
                .boxed()
                .collect(Collectors.toList());
        collect.sort(Comparator.naturalOrder());

    }
}
