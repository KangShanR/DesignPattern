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
class AccessTest {
    public static char C = 100;

    int count;

    private AccessTest(int i){
        this.count = i;
    }

    static {//executed first of all
        System.out.println("static block");
    }

    {
        count = 44;
        System.out.println(count);
        System.out.println("block44");
    }



    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello");
        System.out.printf("hello", OverloadTest.class)
                .printf(" world")
                .printf(", can you hear me?")
                .flush();

        AccessTest accessTest = new AccessTest(1);
        System.out.println(accessTest.count);

        System.out.println(Integer.toBinaryString(223));

        OverloadTest overloadTest = new OverloadTest();
        //result: 各个类中的静态块会先执行，但在未访问到其他类的实例或静态代码前，其静态代码并不会执行。

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