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
        int[] array = {1,31,23,33,2,22,33,32,21,32,34};
        Arrays.stream(array).forEach(i -> System.out.print(i + "  "));
        System.out.println();
        sort(array, 0, array.length - 1);
        Arrays.stream(array).forEach(i -> System.out.print(i + "  "));
    }

    public static void sort(int[] array, int startIndex, int endIndex) {
        int index = partIndex(array, startIndex, endIndex);

        //right partition
        if (endIndex - index > 1) {
            sort(array, index + 1, endIndex);
        }
        //left partition
        if (index - startIndex > 1) {
            sort(array, startIndex, index - 1);
        }
    }

    public static int partIndex(int[] array, int startIndex, int endIndex) {
        int temp;
        if (endIndex - startIndex == 1) {
            if (array[startIndex] > array[endIndex]) {
                temp = array[startIndex];
                array[startIndex] = array[endIndex];
                array[endIndex] = temp;
            }
            return startIndex;
        }
        int pivot = array[endIndex];
        int i = startIndex;
        for (int j = startIndex; j < endIndex; j++) {
            if (array[j] <= pivot) {
                if ((temp = array[i]) > pivot) {
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
        return i;
    }
}
