package java8inaction.stream.muiltipleoperate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author KangShan
 * @date 2019/12/26 1:51
 */
public class MultiOperateStreamTest {

    public static void iterator(String[] args) {
        List<String>      strs = Arrays.stream(args).collect(Collectors.toList());
        Iterator<String> iterator = strs.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        iterator.remove();
    }

    public static void main(String[] args) {
        String[] strs = {"1","2","23","kang", "shan", "ssr"};
        Stream<String> stream = Arrays.stream(strs);
        StreamForker.Results results = new StreamForker<>(stream)
                .fork("1", s -> s.filter(i -> i.length() > 3).collect(Collectors.joining(";")))
                .fork("2", s -> s.filter(i -> i.length() > 0).collect(Collectors.joining(";")))
//                .fork("3", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
//                .fork("4", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
//                .fork("5", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
//                .fork("6", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
//                .fork("7", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
//                .fork("8", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
//                .fork("9", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
//                .fork("10", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
//                .fork("11", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
//                .fork("12", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
//                .fork("13", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
                .fork("17", s -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    return s.filter(i -> i.length() < 3).collect(Collectors.joining(";"));})
                .fork("14", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
                .fork("15", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
                .fork("16", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
                .getResults();
        System.out.println(results.get("1").toString());
        System.out.println(results.get("2").toString());
//        System.out.println(results.get("3").toString());
//        System.out.println(results.get("4").toString());
//        System.out.println(results.get("5").toString());
//        System.out.println(results.get("6").toString());
//        System.out.println(results.get("7").toString());
//        System.out.println(results.get("8").toString());
//        System.out.println(results.get("9").toString());
//        System.out.println(results.get("10").toString());
        System.out.println(" 17: " + results.get("17").toString());
//        System.out.println(results.get("11").toString());
//        System.out.println(results.get("12").toString());
//        System.out.println(results.get("13").toString());
//        System.out.println(results.get("14").toString());
//        System.out.println(results.get("15").toString());
//        System.out.println(results.get("16").toString());
    }
}
