package thinkinginjava.innerclass;

/**
 * 局部内部类
 * @author KangShan
 * @date 2020/1/6 13:48
 */
public class LocalInnerClass {
    void method() {
        System.out.println("method print");
    }
    public static void main(String[] args) {
        /* Local inner class */
        class LocalInnerClass2 {
            void method2() {
                System.out.println("method2 print");
            }
        }
        //local class instance
        new LocalInnerClass2().method2();
        //anonymous inner class instance
        LocalInnerClass localInnerClass = new LocalInnerClass() {
            /**
             * compile error
             * you can not initialize a instance in anonymous inner class
             */
//            LocalInnerClass(String string) {
//                System.out.println(string);
//            }
            //override the method
            @Override
            void method() {
                System.out.println("override method");
                super.method();
            }

            void method2(){
                System.out.println("method2 initialize");
            }
            //after initialize
            {

                System.out.println("post initialize");
                method2();
            }
        };
    }
}
