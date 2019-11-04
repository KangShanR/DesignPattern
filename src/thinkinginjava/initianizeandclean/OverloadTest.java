package thinkinginjava.initianizeandclean;

import java.util.stream.Stream;

/**
 * @author KangShan
 * @date 2019/8/12 19:50
 */
public class OverloadTest {

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
        System.out.println("bcd".getBytes()[0]);
        Stream.of("bcd".getBytes()).forEach(System.out::println);
        byte b = "b".getBytes()[0];
        new OverloadTest().byteOverloadTest(b);
    }
}
