package thinking_in_java.initianize_and_clean;

import jdk.net.SocketFlow;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

/**
 * @author KangShan
 * @date 2019/8/12 19:50
 */
@NoArgsConstructor
public class OverloadTest {

    public OverloadTest(String i){
        System.out.println(i);
    }

    void byteOverloadTest(char c){
        System.out.println("byte to char : " + c);
    }
    void byteOverloadTest(int c){
        System.out.println("byte to char : " + c);
    }
    void byteOverloadTest(short c){
        System.out.println("byte to char : " + c);
    }

    public static void main(String[] args){
//        System.out.println("bcd".getBytes()[0]);
//        Stream.of("bcd".getBytes()).forEach(System.out::println);
//        byte b = "b".getBytes()[0];
//        new OverloadTest().byteOverloadTest(b);

        System.out.println("main start ...");
//        StaticClassInitialization s = new StaticClassInitialization();
        System.out.println(StaticClassInitialization.staticOverLoad);
        /* 此处证明，静态代码的执行是只要首次执行到 class 的代码，不管是静态成员块的执行还是实例的初始化，
         * 都会先执行静态成员代码。
         * 而非静态成员的初始化却要第一个实例初始化时才会执行到 */
        System.out.println("main end ...");

    }
}
