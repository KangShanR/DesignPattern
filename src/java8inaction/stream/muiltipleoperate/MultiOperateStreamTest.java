package java8inaction.stream.muiltipleoperate;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author KangShan
 * @date 2019/12/26 1:51
 */
public class MultiOperateStreamTest {
    public static void main(String[] args) {

        String[] strs = {"1","2","3","kang", "shan"};
        StreamForker.Results results = new StreamForker<>(Arrays.stream(strs))
                .fork("1", s -> s.filter(i -> i.length() > 3).collect(Collectors.joining(";")))
//                .fork("2", s -> s.filter(i -> i.length() > 0).collect(Collectors.joining(";")))
                .getResults();
        Object o = results.get("1");
        System.out.println(o);
        System.out.println(results.get("2").toString());
    }
}
