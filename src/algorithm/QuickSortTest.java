package algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author KangShan
 * @date 2019/6/5 11:48
 */
public class QuickSortTest {


    private static final int TWO_ELEMENTS_ARRAY_LENGTH = 2;


    /**
     * @author  KangShan
     * @params  []
     * @date    2019/6/5 10:27
     */
    @Test
    public void quickSortTest() {

        Random random      = new Random();
        int    arrayLength = 44;
        int[]  ints        = new int[arrayLength];
        for(int i = 0; i < arrayLength; i++){
            ints[i] = random.nextInt(23);
        }
//        ints = new int[]{112, 32, 1, 33};
//        ints = new int[]{13, 30, 19, 13};
        Arrays.stream(ints).forEach(i -> System.out.print(" " + i));
        System.out.println("");
        Arrays.stream(this.arrayQuickSort(ints)).forEach(i -> System.out.print(" " + i));

    }


    /**
     *
     * @author  KangShan
     * @params  [numbers, str]
     * @return  int[]
     * @date    2019/6/5 10:21
     */
    int[] arrayQuickSort(int[] numbers){

        if(numbers.length == 1){
            return numbers;
        }else if(numbers.length == 0){
            throw new IllegalArgumentException("Invalid array: which length is zero.");
        }else if(numbers.length == TWO_ELEMENTS_ARRAY_LENGTH){
            if(numbers[0] <= numbers[1]){
                return numbers;
            }else {
                return new int[]{numbers[1], numbers[0]};
            }
        }else {//数组长度超过 2
            int pivotIndex = numbers.length - 1;
            int leftIndex  = 0;
            int rightIndex = numbers.length - 2;
            while (leftIndex <= rightIndex ){
                //此层循环需要做到让左右两个 索引相遇或错过

                //如果两个左右两个 index 相遇且满足条件直接跳出循环交换 pivot 与左值
                if(leftIndex == rightIndex && numbers[leftIndex] >= numbers[pivotIndex]){
                    break;
                }

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
            //左右两个 index 相遇或越过了，pivot 与左值交换并分割两边的数组
            int temp = numbers[leftIndex];
            numbers[leftIndex] = numbers[pivotIndex];
            numbers[pivotIndex] = temp;
            if(leftIndex == 0){
                return combineArrays(new int[]{numbers[0]}, arrayQuickSort(
                        divideArray(numbers, 1, numbers.length)));
            }else if(leftIndex == numbers.length -1) {
                return combineArrays(arrayQuickSort(
                        divideArray(numbers, 0, numbers.length - 1)),
                        new int[]{numbers[numbers.length -1]});
            }else {
                return combineArrays(combineArrays(arrayQuickSort(divideArray(numbers, 0, leftIndex)),
                        new int[]{numbers[leftIndex]}),
                        arrayQuickSort(divideArray(numbers, leftIndex + 1, numbers.length)));
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
            throw new IllegalArgumentException("Invalid array parameter: " +
                    array1.toString() + "; " + array2.toString());
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
        if(startIndex < 0 || startIndex > length -1 || endIndex < 0){
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
