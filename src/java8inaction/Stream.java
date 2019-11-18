package java8inaction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author KangShan
 * @date 2019/11/15 22:46
 */
public class Stream {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 23, 2, 34);
        Map<Boolean, List<Integer>> collect =
                integers.stream().collect(
                        Collectors.groupingBy(
                                i -> i > 0));

        /**
         * 实现类可以直接调用接口的默认方法,
         * 同时，默认方法也可以被实现类给复写。
         */
        new Stream().sort(Comparator.naturalOrder());
    }

    /***
     * As a default method defined in interface, it could be override in class
     *
     * @author  KangShan
     * @date    2019/11/17 20:37
     */
    public void sort(Comparator c) {

    }

}
