package algorithm;

/**
 * @author KangShan
 * @date 2020/6/3 17:36
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(search(array, 3, 0, array.length - 1));
    }

    static int search(int[] array, int value, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int i = lo + (hi - lo >> 1);
        int target = array[i];
        if (target == value) {
            return i;
        } else if (target > value) {
            return search(array, value, lo, i - 1);
        } else {
            return search(array, value, i + 1, hi);
        }
    }
}
