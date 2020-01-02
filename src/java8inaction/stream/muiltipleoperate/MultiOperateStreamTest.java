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
                .fork("3", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
                .getResults();
        Object o = results.get("1");
        System.out.println(o);
        System.out.println(results.get("2").toString());
        System.out.println(results.get("3").toString());
    }
}
