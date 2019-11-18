package thinking_in_java.innerclass;

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
