package operator.character;

/**
 * @author KangShan
 * @date 2019/8/1 23:19
 */
public class ShiftingBitTest {

    public static void main(String[] args){
        int i = 1;
        int j = -1;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i>>10));
        System.out.println(Integer.toBinaryString(j));
        System.out.println(j);
        System.out.println(Integer.toBinaryString(j>>>=10));
        System.out.println(j);
        System.out.println(Integer.toBinaryString(j<<=10));
        System.out.println(j);

        System.out.println("---------------");
        short k = -1;
        byte l = 12;
        char m = 'm';
        System.out.println(Integer.toBinaryString(k));
        //byte/short/char 的任何运算都会产生一个 int 结果。
        // 以下的
        // k = k * k; l = l + k; m = m - l;
        // 都会产生一个转型的编译错误，说明了结论
        k= (short) (k-m);
        System.out.println((int)m);
        System.out.println(k);

        System.out.println("-----------------");
        int in;
        in = Integer.MAX_VALUE + 1;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(in);
        Iterable<Integer> ints;
    }
}
