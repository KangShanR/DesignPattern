package thinking_in_java.ref;

import java.util.Arrays;

/**
 *
 * @author KangShan
 * @date 2019/10/17 15:39
 */
public class Ref {
    public static void main(String[] args){
        /**
         * Class 获取
         */
        System.out.println("getClasses...");
        Arrays.stream(Character.class.getClasses()).forEach(System.out::println);
        System.out.println("getDeclaredClasses...");
        Arrays.stream(Character.class.getDeclaredClasses()).forEach(System.out::println);
        System.out.println(Integer.TYPE);
    }
}
