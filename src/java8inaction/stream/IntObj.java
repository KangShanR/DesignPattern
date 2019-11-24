package java8inaction.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author KangShan
 * @date 2019/11/24 11:40
 */
@Data
@AllArgsConstructor
public class IntObj {
    private int i;

    @Override
    public String toString() {
        System.out.println("iiii:" + i);
        return "IntObj{" +
                "i=" + i +
                '}';
    }
}
