package thinking_in_java.innerclass;

/**
 * @author KangShan
 * @date 2019/11/17 19:08
 */
public class Outer {
    class Inner {

    }

    Inner getInner(){
        return new Inner();
    }

    public static void main(String[] args) {
        Inner inner = new Outer().getInner();
    }
}
