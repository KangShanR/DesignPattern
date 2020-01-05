package thinking_in_java.innerclass;

/**
 * 继承内部类，注意构造函数特定语法
 * @author KangShan
 * @date 2019/11/17 19:13
 */
public class InnerClassTest extends Outer.Inner2 {
    InnerClassTest(Outer in) {
        /**
         * 此处 super 调用的意义不再是调用外部类的构造方法了，
         * 调用 inner 内部类的构造方法
         */
        in.super();
        System.out.println("test construct");
    }

    public static void main(String[] args) {
        /**
         * 匿名内部类的创建使用，第一个 `{}` 内重写类结构，可重写方法与初始化语句；
         *      第二个 `{}` 在第一个 `{}` 之中（无所谓与其他定义语句的先后顺序），
         *      写下这个实例的执行语句，可调用这个实例的方法。
         */
        new Outer() {
            {
                getInner();
            }
            @Override
            Outer.Inner getInner() {
                System.out.println("get outer by anonymous class");
                return null;
            }
        };
        Outer       outer = new Outer();
        System.out.println(outer);
//        Inner inner = outer.new Inner();
//        System.out.println(inner.getOuter());
//        NestedClass.Inner inner = new NestedClass.Inner();
//        System.out.println();
//        new NestedInInterface.Nested();
        InnerClassTest innerClassTest = new InnerClassTest(outer);
        System.out.println(innerClassTest.getOuter());
    }
}
