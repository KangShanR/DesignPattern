package thinkinginjava._interface.abstruct_class_and_interface;

/**
 * @author KangShan
 * @date 2019/11/13 23:28
 */
public class SubClass extends AbstractClass {
    public static int i = 3;

    @Override
    void print() {
        System.out.println("subclass print i : " + i);
    }

    void println(int i){
        System.out.println(i);
    }

    public static void main(String[] args) {

    }
}
