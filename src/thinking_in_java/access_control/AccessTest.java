package thinking_in_java.access_control;


import lombok.extern.slf4j.Slf4j;
import thinking_in_java.initialization_and_clean.OverloadTest;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author KangShan
 * @date 2019/10/23 21:26
 */
@Slf4j
public class AccessTest {
    static char C = 100;

    private int count;

    private AccessTest(int i){
        this.count = i;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello");
        System.out.printf("hello", OverloadTest.class)
                .printf(" world")
                .printf(", can you hear me?")
                .flush();

        System.out.println(Integer.toBinaryString(223));

        PrintStream printStream = new PrintStream("S");
    }

    /**
     * 使用反编译查看，内部类的构造。
     */
    private class PrivateInner{
    }
    public class PublicInner{
    }
    public static class StaticPublicInner{
    }
    private static class StaticPrivateInner{

    }
}
