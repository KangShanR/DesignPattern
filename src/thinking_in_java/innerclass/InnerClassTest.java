package thinking_in_java.innerclass;

/**
 * @author KangShan
 * @date 2019/11/17 19:13
 */
public class InnerClassTest {
    public static void main(String[] args) {
        Outer       outer = new Outer();
        System.out.println(outer);
        Outer.Inner inner = outer.new Inner();
        System.out.println(inner.getOuter());
//        NestedClass.Inner inner = new NestedClass.Inner();
//        System.out.println();
//        new NestedInInterface.Nested();
    }
}
