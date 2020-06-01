package algorithm;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * quick sort can't be stable
 * @author KangShan
 * @date 2020/6/1 15:43
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {1,3,3,3,2,2,33,32,21,32,34};
        Arrays.stream(array).forEach(i -> System.out.print(i + "  "));
        System.out.println();
        sort(array, 0, array.length - 1);
        Arrays.stream(array).forEach(i -> System.out.print(i + "  "));
    }

    public static void sort(int[] array, int startIndex, int endIndex) {
        int temp;
        if (endIndex - startIndex < 1) {
            return;
        } else if (endIndex - startIndex == 1) {
            if (array[startIndex] > array[endIndex]) {
                temp = array[startIndex];
                array[startIndex] = array[endIndex];
                array[endIndex] = temp;
            }
            return;
        }
        int pivot = array[endIndex];
        int i = startIndex;
        for (int j = startIndex; j < endIndex; j++) {
            if (array[j] <= pivot) {
                temp = array[i];
                if (array[i] > pivot && i != j) {
                    array[i] = array[j];
                    array[j] = temp;
                }
                i++;
            }
        }
        if (i != endIndex) {
            temp = array[i];
            array[i] = pivot;
            array[endIndex] = temp;
        }

        //right partition
        sort(array, i + 1, endIndex);
        //left partition
        sort(array, startIndex, i - 1);
    }
}
