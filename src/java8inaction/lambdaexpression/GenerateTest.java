package java8inaction.lambdaexpression;

import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author KangShan
 * @date 2019/12/17 12:32
 */
@NoArgsConstructor
public class GenerateTest<T> {
//    List<String> strs = Arrays.asList("g");

    T t;

    GenerateTest(T t){
        this.t = t;
    }


    public static void main(String[] args) {
        GenerateTest<Long> longGenerateTest = new GenerateTest<>(3L);

        Map<String, Long> map = new HashMap<String, Long>() {
            {
                put("dfd", 33L);
            }
        };
        System.out.println(map);
        System.out.println(longGenerateTest.t);
    }

}
