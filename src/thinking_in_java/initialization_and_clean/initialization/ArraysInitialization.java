package thinking_in_java.initialization_and_clean.initialization;

/**
 * 数组的初始化
 *
 * @author KangShan
 * @date 2019/11/5 22:38
 */
public class ArraysInitialization {
    int[] ints = new int[3];
    int   i    = 3;
    Byte b = 2;

    public final        char c           = 3;
    public final        char copyInt2    = 3;
    public final        int  copyInt     = 3;
    public static final char STATIC_CHAR = 'A';

    ArraysInitialization(int i) {
        this.i = i;
        char b = c;
        System.out.println(str);
    }

    public static void main(String[] args) {
        System.out.println(new ArraysInitialization(1).str);
    }

    String str = "final string";

    Integer j = 3;
}
