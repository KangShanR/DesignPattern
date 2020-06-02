package algorithm;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/**
 * quick sort can't be stable
 * @author KangShan
 * @date 2020/6/1 15:43
 */
public class QuickSort {
    public static void main(String[] args) {
        int j = 1;
        switchT(j);
        int[] array = {1,31,23,33,2,22,33,32,21,32,34};
        Arrays.stream(array).forEach(i -> System.out.print(i + "  "));
        System.out.println();
        System.out.println(select(array, 8,0, array.length -1));
        sort(array, 0, array.length - 1);
        Arrays.stream(array).forEach(i -> System.out.print(i + "  "));
    }

    private static void switchT(int j) {
        switch (j) {
            case 1:
                System.out.println(j);
            case 2:
                System.out.println(j);
                break;
            case 3:
                System.out.println(j);
                default:
                    System.out.println("default");
        }
    }

    /**
     * select element in rank
     * @param   array the array
     *                rank, startIndex, endIndex
     * @return  int the element
     * @date    2020/6/2 12:28
     */
    public static int select(int[] array, int rank, int startIndex, int endIndex) {
        int index = partIndex(array, startIndex, endIndex);
        int no    = index + 1;
        if (no > rank) {
            return select(array, rank, startIndex, index - 1);
        } else if (no < rank) {
            return select(array, rank, no, endIndex);
        } else {
            return array[index];
        }
    }

    /**
     * sort those elements in array between startIndex and endIndex
     * @param   array the array be sorted
     * @param   startIndex  thd index started in array
     *                     endIndex
     * @date    2020/6/2 16:05
     */
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

    /**
     * part the array
     * @param   array startIndex, endIndex
     * @return  the index be parted in array
     * @date    2020/6/2 16:08
     */
    public static int partIndex(int[] array, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return startIndex;
        }
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
