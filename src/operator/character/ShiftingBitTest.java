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
        System.out.println(Integer.toBinaryString(k));
    }
}
