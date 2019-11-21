package java8inaction.lambdaexpression;

import java.util.Arrays;
import java.util.function.BinaryOperator;

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
    }
}
