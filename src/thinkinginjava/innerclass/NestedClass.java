package thinkinginjava.innerclass;

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

    void method() {
        System.out.println("outer method");
    }

    static class Inner{
        {
            System.out.println("Inner initialize...");
            main(new String[]{""});
        }

        public static void main(String[] args) {
            NestedClass nestedClass = new NestedClass();
//            System.out.println(nestedClass.new Inner());
        }
    }

    public static void main(String[] args) {
        Inner inner = new Inner();
    }
}
