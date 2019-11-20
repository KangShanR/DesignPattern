package thinking_in_java.innerclass;

/**
 * @author KangShan
 * @date 2019/11/20 23:48
 */
public class AnonymousInnerClass {
    int i = 1;
    static int j = 2;

    public static void main(final String[] args, final Integer kk) {
        int k = 3;
        new Outer(){
            int c;
            {
                c = 3;
                j = 3;
//                k = 3;
                if(kk > 3){

                }
            }

            @Override
            Inner getInner() {
                if(args == null){

                }
                return super.getInner();
            }
        };
        new TestInterface(){

            @Override
            public void greet() {
                j = 3;
            }
        };
    }
}
