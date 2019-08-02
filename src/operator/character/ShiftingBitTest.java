package operator.character;

/**
 * test codes about the computer bit shifting operation
 * @author KangShan
 * @date 2019/8/1 23:19
 */
public class ShiftingBitTest {

    /**
     * 对于位移操作符：
     * 1. `<<` 左移，左移运算，符号位不变。也就是不管是正数还是负数，其符号位应该一直保持不变。
     * 2. 右移运算分两种：
     *      1. 有符号右移 `>>` 根据其符号位来，如果符号位是 1 ，则在前位填 1，如果符号位是 0 ，将在前位填 0
     *      2. 无符号右移 `>>>`
     */

    public static void main(String[] args){

        System.out.println("positive int ------------------");
        int i = 1;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i>>10));
        System.out.println(Integer.toBinaryString(i<<=10));
        System.out.println(i);
        System.out.println("negative int -------------------");
        int j = -1;
        System.out.println(Integer.toBinaryString(j));
        System.out.println(j);
        System.out.println(Integer.toBinaryString(j>>10));
        System.out.println(Integer.toBinaryString(j>>>=10));
        System.out.println(j);
        System.out.println(Integer.toBinaryString(j<<=10));
        System.out.println(j);

        System.out.println("negative short ---------------");
        short k = -1;
        System.out.println(Integer.toBinaryString(k));
        System.out.println(k<<16);
        System.out.println(Integer.toBinaryString(k<<15));
        System.out.println(Integer.toBinaryString(k<<16));
    }
}
