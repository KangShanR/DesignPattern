package thinking_in_java.innerclass;

/**
 * @author KangShan
 * @date 2019/11/20 23:48
 */
public class AnonymousInnerClass {
    {
        System.out.println("initializing ...");
//        this.i = 5;
        System.out.println("i :" + this.i);
    }
    int i = 1;
    static int j = 2;

    void setOut(String i) {
        new TestInterface() {
            private String j = i;
            @Override
            public void greet() {
                System.out.println(j);
            }
        };
    }

    AnonymousInnerClass() {
        System.out.println("constructed on nothing!");
        System.out.println("i  " + i);
    }
    AnonymousInnerClass(int i) {
        this.i = i;
        System.out.println("constructed on i!");
    }

    public static void main(String[] args) {
//        new AnonymousInnerClass();

        /**
         * for the anonymous inner class:
         * First, the instance will be constructed by the specific constructor;
         * Second, refactor the upper type's members;
         * Thirdly, execute the code in secondly scope
         */
        new AnonymousInnerClass(4){
            private String[] str = args;
            void setI(int i) {
                this.i = i;
            }{
                System.out.println("initialization ... ");
                System.out.println("i = " + i);
            }

        };
//        int k = 3;
//        new Outer(){
//            int c;
//            {
//                c = 3;
//                j = 3;
////                k = 3;
//            }
//
//            @Override
//            Inner getInner() {
//                if(args == null){
//
//                }
//                return super.getInner();
//            }
//        };
//        new TestInterface(){
//
//            @Override
//            public void greet() {
//                j = 3;
//            }
//        };
    }
}
