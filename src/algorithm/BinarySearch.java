package algorithm;

/**
 * @author KangShan
 * @date 2020/6/3 17:36
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 4,6};
        int[] array1 = {1,1};
//        System.out.println(search(array, 5, 0, array.length - 1, false));
        System.out.println(obscureSearch(array, 2, 0 , array.length -1, false));
    }

    static int search(int[] array, int value, int lo, int hi, boolean firstOne) {
        if (hi == lo) {
            return array[lo] == value ? lo : -1;
        }
        int i = lo + (hi - lo >> 1);
        int target = array[i];
        if (target == value) {
            return boundIndex(array, i, firstOne);
        } else if (target > value) {
            return i == 0 ? -1 : search(array, value, lo, i - 1, firstOne);
        } else {
            return (i == array.length - 1) ? -1 : search(array, value, i + 1, hi, firstOne);
        }
    }

    /**
     * todo need be optimized
     * @param   array, value, lo, hi, firstOne
     * @return  int
     * @date    2020/6/10 18:27
     */
    static int obscureSearch(int[] array, int value, int lo, int hi, boolean firstOne) {
        if (lo - hi == -1) {
            if (array[lo] == value) {
                return boundIndex(array, lo, firstOne);
            } else if (array[hi] == value) {
                return boundIndex(array, hi, firstOne);
            }else if(array[lo] > value) {
                return firstOne? lo: -1;
            } else if (array[hi] < value) {
                return firstOne ? -1 : hi;
            }else {//between low and high
                return firstOne ? hi : lo;
            }
        }
        int i = lo + (hi - lo >> 1);
        int target = array[i];
        if (target == value) {
            return boundIndex(array, i, firstOne);
        } else if (target > value) {
            if (lo - i == -1) {
                if (array[lo] == value) {
                    return boundIndex(array, lo, firstOne);
                } else if (array[i] == value) {
                    return boundIndex(array, i, firstOne);
                }else if(array[lo] > value) {
                    return firstOne? lo: -1;
                } else if (array[i] < value) {
                    return firstOne ? -1 : i;
                }else {//between low and high
                    return firstOne ? lo : i;
                }
            }
            return obscureSearch(array, value, lo, i - 1, firstOne);
        } else {
            if (hi - i == -1) {
                if (array[hi] == value) {
                    return boundIndex(array, hi, firstOne);
                } else if (array[i] == value) {
                    return boundIndex(array, i, firstOne);
                }else if(array[i] > value) {
                    return firstOne? i: -1;
                } else if (array[hi] < value) {
                    return firstOne ? -1 : hi;
                }else {//between low and high
                    return firstOne ? i : hi;
                }
            }
            return obscureSearch(array, value, i + 1, hi, firstOne);
        }
    }

    static int boundIndex(int[] array, int index, boolean firstOne) {
        int value = array[index];
        if(firstOne) {
            while (index > 1 && array[--index] == value) {}
            return index > 1 ? ++index:index;
        }else {
            while (index< array.length - 1 && array[++index] == value) {}
            return index < array.length - 1 ? --index:index;
        }
    }
}
