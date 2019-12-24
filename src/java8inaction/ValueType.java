package java8inaction;

import java.util.ArrayList;

/**
 * @author KangShan
 * @date 2019/12/23 23:00
 */
public class ValueType {
    int i;
    Integer j;

    ArrayList<Integer> lists;

    ValueType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public static void main(String[] args) {
        ValueType valueType = new ValueType(1, 127);
        ValueType valueType2 = new ValueType(1, 127);
        System.out.println(valueType.i == valueType2.i);
        System.out.println(valueType.j == valueType2.j);
    }
}
