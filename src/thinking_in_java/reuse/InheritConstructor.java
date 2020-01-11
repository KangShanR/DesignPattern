package thinking_in_java.reuse;

import lombok.Getter;

/**
 * 继承测试
 * @author KangShan
 * @date 2019/10/31 23:49
 */
public class InheritConstructor extends Inherited{
    static void greet(){
        System.out.println("static greet...");
    }


    public InheritConstructor (){
        System.out.println("InheritConstructor .......");
    }

    @Getter
    Integer i = 1;
    int j = i;
    int k = 0;

    public static void main(String[] args){
        System.out.println(new InheritConstructor().getI());
        /**
         * 使用实例引用句静态成员引起的错误，
         * 静态方法的调用忽略其表达式部分而导致此处并不会抛出 NollPointerException
         */
//        ((InheritConstructor)null).greet();
//
//        InheritConstructor s = new InheritConstructor();
//
//        System.out.println(s.getCount());
//        System.out.println(args);
    }

}
