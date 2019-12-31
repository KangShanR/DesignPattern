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
     *      1. 有符号右移 `>>` 根据其符号位来，如果符号位是 1 ，则在前位填 1，如果符号位是 0 ，
     *          将在前位填 0
     *      2. 无符号右移 `>>>` 直接在高位填 0 ，负数会直接转为正数
     */
    private static void bitShiftingTest() {
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
        System.out.println(Integer.toBinaryString(j>>=10));
        System.out.println(j);
        System.out.println(Integer.toBinaryString(j>>>=10));
        System.out.println(j);
        System.out.println(Integer.toBinaryString(j<<=10));
        System.out.println(j);

        System.out.println("negative short ---------------");
        short k = -1;
        byte l = 12;
        char m = 'm';
        System.out.println(Integer.toBinaryString(k));
        System.out.println(k<<16);
        System.out.println(Integer.toBinaryString(k<<15));
        System.out.println(Integer.toBinaryString(k<<16));
        //byte/short/char 的任何运算都会产生一个 int 结果。
        // 以下的
        // k = k * k; l = l + k; m = m - l;
        // 都会产生一个转型的编译错误，说明了结论
        k= (short) (k-m);
        System.out.println((int)m);
        System.out.println(k);

        System.out.println("bit overflow -----------------");
        int in;
        in = Integer.MAX_VALUE + 1;
        long ll = Integer.MAX_VALUE * 2 * 3;
        System.out.println(ll);
        System.out.println(Integer.MAX_VALUE);
    }

    public static void bitShifting() {
        System.out.println(Integer.MIN_VALUE - 1 == Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(~1));
        System.out.println(Integer.toBinaryString(1^1));
    }

    /**
     * 验证位移运算
     * `<<` `>>` 两种操作会对符号位进行特殊管理：在进行移位后对符号进行填充符号
     * 否有溢出
     * `>>>` *将不对称号位进行补充*
     * @date    2019/12/30 18:58
     */
    static void rightAndLestShifting() {

        /**
         * `<<` 不对符号位特殊处理，bit 直接向基移动覆盖符号位在所不惜
         * 任何数 `<<` 32 与32 的倍数位都将是其本身;
         * 注意以下两个操作的不同之处：
         *      1 << 32 与 1<<31<<1
         *      前者是将一个数直接移动 32 位，而后一个是将 1 左移31 位后成为另一个数后再左移 1 bit。
         *      失之毫厘，差之千里：前者结果是1，后者结果是 0（
         *          在位移越界后，越界的 bit 全部被抹掉，直到位数达到 32（数的类型决定） 的倍数。
         *          准确地讲，应该是对位移位数进行取模后再进行位移）；
         */
        System.out.println(Integer.toBinaryString(1<<31<<1));
        System.out.println(Integer.toBinaryString(1<<32));
        /**
         * `>>>` 将不对符号位特殊处理：符号位与其他位一起向右移动，与 `<<` 原理一致
         * `>>` 在右移时会将前位进行补 符号位：如果是负数将不停地填充 1 ，正数则填充 0
         */
        System.out.println("正数右移：" + Integer.toBinaryString(3>>1));
        System.out.println("负数右移：" + Integer.toBinaryString(-1024));
        System.out.println("负数右移：" + Integer.toBinaryString(-1024 >> 31));
        System.out.println("负数右移：" + Integer.toBinaryString(-1024 >>> 3));
//        System.out.println(Integer.toBinaryString(-1));
//        System.out.println(Integer.toBinaryString(-1>>>1));
//        System.out.println(-1>>>1);
    }

    public static void main(String[] args){
        rightAndLestShifting();
//        bitShifting();
    }
}
