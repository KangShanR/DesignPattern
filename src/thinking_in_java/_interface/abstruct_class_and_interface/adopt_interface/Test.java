package thinking_in_java._interface.abstruct_class_and_interface.adopt_interface;

import thinking_in_java._interface.abstruct_class_and_interface.AbstractClass;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * 适配接口
 * @author KangShan
 * @date 2019/11/17 12:17
 */
public class Test implements Readable{
    public static void main(String[] args) {
        System.out.println(TestInterface.COUNT);
        System.out.println(AbstractClass.a);;
        Scanner scanner = new Scanner(new Test());
        while (scanner.hasNextInt()){
            System.out.println(scanner.nextInt());
        }
    }

    int count = 5;

    @Override
    public int read(CharBuffer cb) {
        if(count-- == 0){
            return -1;
        }else {
//            cb.append("a");
            cb.append("123");
//            cb.append("1.32233");
//            cb.append("123 ");
            cb.append('\n');
        }
        return 0;
    }
}
