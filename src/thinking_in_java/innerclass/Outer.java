package thinking_in_java.innerclass;

import java.io.OutputStream;

/**
 * @author KangShan
 * @date 2019/11/17 19:08
 */
public class Outer {
    {
        System.out.println("out initialize");
    }
    Outer(){
        System.out.println("outer construct");
    }
    class Inner {
        {
            System.out.println("inner initializing");
        }

        Inner() {
            System.out.println("inner construct");
        }
        Outer getOuter(){
            return Outer.this;
//            return null;
        }
    }
    class Inner2 {
        {
            System.out.println("inner2 initializing");
        }

        Inner2() {
            System.out.println("inner2 construct");
        }
        Outer getOuter(){
            return Outer.this;
//            return null;
        }
    }

    /**
     * show the method code of getting the outer object's reference
     * & new a inner object on a outer object
     * @return
     */
    Inner getInner(){
        Outer.this.toString();
        return this.new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.getInner();

        System.out.println(inner);
        System.out.println(inner.getOuter());
        System.out.println(inner.getOuter() == outer);
    }
}
