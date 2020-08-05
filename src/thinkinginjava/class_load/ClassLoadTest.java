package thinkinginjava.class_load;

/**
 * @author KangShan
 * @date 2019/11/4 19:19
 */
public class ClassLoadTest {
    void print(Integer i){
        switch (i){
            case 1:
                System.out.println(1);
            default:
                System.out.println(2);
        }
        System.out.println("doogy");
    }

    public static void main(String[] args) {
        new ClassLoadTest().print(null);
    }
}
