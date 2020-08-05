package thinkinginjava.polymorph;

/**
 * @author KangShan
 * @date 2019/11/11 23:33
 */
public class Test {
    public static void main(String[] args) {
        /**
         * downcast & RTTI
         */
        Base base = new Base();
        Exported exported = new Exported();
        Base[] bases = {base, exported};

        System.out.println("base method print:");
        bases[0].base();
        bases[1].base();

        System.out.println("base private method print:");
        ((Exported)bases[1]).basePrivate();
        ((Exported)bases[0]).basePrivate();
    }
}
