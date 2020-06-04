package algorithm;

/**
 * @author KangShan
 * @date 2020/6/3 17:36
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3,3,3, 4,4,4,4, 5,5,5,5, 6, 7, 8,8,8,8};
        int[] array1 = {1,1};
        System.out.println(search(array1, 0, 0, array1.length - 1, true));
    }

    static int search(int[] array, int value, int lo, int hi, boolean firstOne) {
        if (hi == lo) {
            return array[lo] == value ? lo : -1;
        }
        int i = lo + (hi - lo >> 1);
        int target = array[i];
        if (target == value) {
            if(firstOne) {
                while (i > 1 && array[--i] == value) {}
                return i > 1 ? ++i:i;
            }else {
                while (i< array.length - 1 && array[++i] == value) {}
                return i < array.length - 1 ? --i:i;
            }
        } else if (target > value) {
            return i == 0 ? -1 : search(array, value, lo, i - 1, firstOne);
        } else {
            return (i == array.length - 1) ? -1 : search(array, value, i + 1, hi, firstOne);
        }
    }

    static int obscureSearch(int[] array, int value, int lo, int hi, boolean firstOne) {
        if (array[lo] == value) {
            return lo;
        } else if (array[hi] == value) {
            return hi;
        }
        int i = lo + (hi - lo >> 1);
        int target = array[i];
        if (target == value) {
            if(firstOne) {
                while (i > -1 && array[i] == value) {i--;}
                return i;
            }else {
                while (i< array.length && array[i] == value) {i++;}
                return i;
            }
        } else if (i - lo == 1) {
            return firstOne ? lo : i;
        } else if (target > value) {
            return search(array, value, lo, i - 1, firstOne);
        } else {
            return search(array, value, i + 1, hi, firstOne);
        }
    }
}
