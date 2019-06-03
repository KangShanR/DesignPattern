package designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * @description
 * @author KangShan
 * @date 2019/2/19 15:36
 */
@Slf4j
public class Test {

    public static void main(String[] args){
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();

        Set<Map.Entry<String, Charset>> entries = stringCharsetSortedMap.entrySet();
        Iterator<Map.Entry<String, Charset>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Charset> next = iterator.next();
            log.info("key:" + next.getKey());
            log.info("name:" + next.getValue().name());
        }

    }


    int[] arrayQuickSort(int[] numbers){

        if(numbers.length == 1){
            return numbers;
        }else if(numbers.length == 0){
            throw new IllegalArgumentException("参数错误");
        }else if(numbers.length == 2){
            if(numbers[0] <= numbers[1]){
                return numbers;
            }else {
                return new int[]{numbers[1], numbers[0]};
            }
        }else {
            int pivotIndex = numbers.length,
                    leftIndex = 0,
                    rightIndex= numbers.length - 1;
            

            return arrayQuickSort(numbers);
        }
    }
}
