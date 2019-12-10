package java8inaction.optional;

import java.util.Optional;

/**
 * @author KangShan
 * @date 2019/12/10 23:54
 */
public class OptionalTest {

    public static void main(String[] args) {
        System.out.println(Optional.of(1)
                .map(String::valueOf)
                .map(Integer::new)
                .flatMap(Optional::of)
                .flatMap(Optional::ofNullable)
                .get() == 1);
    }
}
