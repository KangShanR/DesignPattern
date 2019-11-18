package thinking_in_java.innerclass;

/**
 * @author KangShan
 * @date 2019/11/18 23:03
 */
public class NestedClass {
    {
        System.out.println("Nested out class");
    }

    NestedClass(){
        System.out.println("Nested out construct");
    }

    static class Inner{
        {
            System.out.println("Inner initialize...");
        }
    }

    public static void main(String[] args) {
        new Inner();
    }
}
