package thinking_in_java.reuse;

/**
 * @author KangShan
 * @date 2019/10/31 23:59
 */
public class Inherited {

    /**
     * 此番定义只将数组声明与数组长度声明，并没有将元素构造出来
     */
    private InheritConstructor[] constructors = new InheritConstructor[4];

    /**
     * 显示如此定义变量，在构造对象时就将成员构造出来
     */
    private InheritConstructor constructor = new InheritConstructor();


    public static void main(String[] args){
        Inherited inherited = new Inherited();
        System.out.println(inherited.constructors[0]);
        System.out.println(inherited.constructor);
    }
}
