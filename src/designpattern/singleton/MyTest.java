package designpattern.singleton;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @description
 * @author KangShan
 * @date 2019/2/19 15:36
 */
@Slf4j
public class MyTest {

    public static void main(String[] args){


    }

    @Test
    public void getBytesTest() throws UnsupportedEncodingException {
        byte[] bytes = "abc123我".getBytes("GBK");
        for(int i = 0; i < bytes.length; i++){
            System.out.println(bytes[i]);
        }
        System.out.println(new String(bytes, Charset.forName("GBK")));
    }

    @Test
    public void mapEntryTest() {
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();

        Set<Map.Entry<String, Charset>> entries = stringCharsetSortedMap.entrySet();
        Iterator<Map.Entry<String, Charset>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Charset> next = iterator.next();
            log.info("key:" + next.getKey());
            log.info("name:" + next.getValue().name());
        }
    }

    @Test
    public void quickSortTest() {

        Random random = new Random();
        int[]  ints   = new int[22];
        for(int i = 0; i < 22; i++){
            ints[i] = random.nextInt(6);
        }
        Arrays.stream(ints).forEach(i -> System.out.print(" " + i));


        Arrays.stream(this.arrayQuickSort(ints)).forEach(i -> System.out.print(" " + i));


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
            int pivotIndex = numbers.length - 1;
            int leftIndex  = 0;
            int rightIndex = numbers.length - 2;
            while (leftIndex < rightIndex){
                while (numbers[leftIndex] < numbers[pivotIndex]){
                    if(leftIndex == pivotIndex){
                        return combineArrays(arrayQuickSort(divideArray(numbers,0, pivotIndex)),
                                new int[]{numbers[pivotIndex]});
                    }
                    leftIndex ++;
                }
                while (rightIndex > leftIndex){
                    if(numbers[rightIndex] < numbers[pivotIndex]){
                        int temp = numbers[rightIndex];
                        numbers[rightIndex] = numbers[leftIndex];
                        numbers[leftIndex] = temp;
                        leftIndex ++;
                        rightIndex--;
                        break;
                    }
                    rightIndex--;
                }

            }
            //左右两个 index 相遇，pivot 与其交换并分割两边的数组
            int temp = numbers[rightIndex];
            numbers[rightIndex] = numbers[pivotIndex];
            numbers[pivotIndex] = temp;
            if(rightIndex == 0){
                return combineArrays(new int[]{numbers[0]}, arrayQuickSort(
                        divideArray(numbers, 1, numbers.length)));
            }else if(rightIndex == numbers.length -1) {
                return combineArrays(arrayQuickSort(
                        divideArray(numbers, 0, numbers.length - 1)),
                        new int[]{numbers[numbers.length -1]});
            }else {
                return combineArrays(combineArrays(arrayQuickSort(divideArray(numbers, 0, rightIndex)),
                        new int[]{numbers[rightIndex]}),
                        arrayQuickSort(divideArray(numbers, rightIndex + 1, numbers.length)));
            }
        }

    }

    /**
     * 将两个数组按序拼装在一起
     * @author      KangShan
     * @param       array1 第一个数组
     * @param       array2 第二个数组
     * @return      拼装后的数组
     * @date        2019/6/3 17:09
     */
    int[] combineArrays(int[] array1, int[] array2){
        if(array1.length == 0 || array2.length == 0){
            throw new IllegalArgumentException("Invalid array parameter: " + array1.toString() + "; " + array2.toString());
        }
        int   length      = array1.length + array2.length;
        int[] result = new int[length];
        for(int i = 0; i<length; i++){
            if(i < array1.length){
                result[i] = array1[i];
            }else {
                result[i] = array2[i - array1.length];
            }
        }
        return result;
    }

    /**
     * 分割数组
     * @author      KangShan
     * @param       array 数组
     * @param       startIndex 开始的 index（包括）
     * @param       endIndex    结束的 index （不包括）
     * @return      分割后的数组
     * @date        2019/6/3 17:28
     */
    int[] divideArray(int[] array, int startIndex, int endIndex){
        int length = array.length;
        if(length == 0){
            throw new IllegalArgumentException("Invalid array: array's length is 0.");
        }
        if(startIndex < 0 || startIndex > length -1 || endIndex < 0 || endIndex > length -1){
            throw new IndexOutOfBoundsException("Array's index out of bounds");
        }
        if(endIndex < startIndex){
            throw new IllegalArgumentException("Invalid element index in array.");
        }
        int[] result = new int[endIndex - startIndex];
        for(int i = startIndex; i < endIndex; i++){
            result[i - startIndex] = array[i];
        }
        return result;
    }

}
