/**
 *
 */
package designpattern.commandpattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.management.ImmutableDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Administrator
 * 经纪人类，负责股票的买卖，命令模式实现的类，将买卖股票的所有命令都按序放在经纪人这儿，开成命令链，最终将整条命令链的执行
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Broker {

    /** 命令链 */
    List<Order> orders = new ArrayList<>();
    /** 当前命令索引 */
    int index    = 0;
    /** 所持股票 */
    Stock        stock  = new Stock(0, "Alibaba");

    void buyStock(int quantity){
        log.info("");
        stock.setQuantity(stock.getQuantity() + quantity);
    }

    public void undo() {
    }


    /**
     *
     * @author  KangShan
     * @param   args nothing
     * @date    2019/7/8 10:00
     */
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.stream().peek(System.out::println).map(int[]::new).peek(a -> System.out.println(a.length)).count();
        byte i = 'z';
        System.out.println(i);
        Integer integer = Integer.MAX_VALUE + 1;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(integer);
    }

    @Test
    public void peekTest(){
        Stream.of("one", "two", "three", "four")
            .filter(e -> e.length() > 3)
            .peek(e -> System.out.println("Filtered value: " + e))
            .map(String::toUpperCase)
            .peek(e -> System.out.println("Mapped value: " + e))
            .collect(Collectors.toList());
    }

}
