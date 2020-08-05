package thinkinginjava.initialization_and_clean.varargs;

/**
 * 可变参数列表：相当于一个数组作为参数
 * @author KangShan
 * @date 2019/11/4 22:45
 */
public class Varargs {

    void test(Character... varargs){
        System.out.println(varargs.getClass());
        System.out.println(varargs.length);
        System.out.println("no float");
    }

//    void test(float i, char... varargs){
//        System.out.println(varargs.getClass());
//        System.out.println(varargs.length);
//        System.out.println(i);
//        System.out.println("float");
//    }

    public static void main(String[] args) {
        new Varargs(){
            {
//                test(1,'H');
                /**
                 * 可变参数引起的不明确引用
                 * 当使用任何一个 Character 包装类作为参数时就会出现引用不明确的错误信息
                 * @why do not get the point
                 */
                test(' ','H');
            }
        };
    }
}
