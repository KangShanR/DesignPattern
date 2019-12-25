package java8inaction.stream.muiltipleoperate;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author KangShan
 * @date 2019/12/26 1:51
 */
public class MultiOperateStreamTest {
    public static void main(String[] args) {
        StreamForker.Results results = new StreamForker<Integer>(IntStream.range(0, 100).boxed())
                .fork("1", s -> s.collect(Collectors.toList()))
                .getResults();
        System.out.println(String.valueOf(results.get("1")));
//                .fork("2", s-> s.)
    }
}
