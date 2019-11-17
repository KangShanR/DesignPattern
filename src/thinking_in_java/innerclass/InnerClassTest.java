package thinking_in_java.innerclass;

/**
 * @author KangShan
 * @date 2019/11/17 19:13
 */
public class InnerClassTest {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().getInner();
        System.out.println(inner);
    }
}
