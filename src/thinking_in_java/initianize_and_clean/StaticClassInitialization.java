package thinking_in_java.initianize_and_clean;

/**
 * @author KangShan
 * @date 2019/9/4 21:26
 */
public class StaticClassInitialization {
    /** 静态成员（静态块与静态变量的初始化）的顺序由成员在 class 代码块中的先后顺序决定 */
    static OverloadTest staticOverLoad = new OverloadTest("static");

    static {
        System.out.println("static block initializing ... ");
    }

    OverloadTest overloadTest = new OverloadTest("not static");

    int count;

    public static void main(String[] args){
        System.out.println("main start ... ");
        StaticClassInitialization s = new StaticClassInitialization();
        System.out.println(s.count);
        System.out.println("main end ... ");
    }
}
