package java8inaction.lambdaexpression;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * late-binding
 * dynamic invoke
 * @author KangShan
 * @date 2019/12/4 0:21
 */
public class LambdaAndClassCode {
    Function<Object, Object> function = p -> {
        p= p.toString();
        Integer[] i = {};

        Runnable inc = () -> i[0] += 1;
        return p;
    };

    public static void main(String[] args) {
        List<BigDecimal> bigDecimals = Arrays.asList(
                BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN);
        bigDecimals.set(0, BigDecimal.valueOf(32));
        bigDecimals.stream().map(b -> b.add(BigDecimal.ONE)).forEach(System.out::println);
    }
}
