package thinking_in_java.reuse;

import lombok.Generated;
import lombok.Getter;

/**
 * @author KangShan
 * @date 2019/10/31 23:59
 */
public class Inherited {

    @Getter
    private Integer count;

    @Getter
    Integer i = 0;

    /**
     * executed before constructor
     */
    {
        System.out.println("new Inherited instance saying ...");
    }


    protected Inherited(){
        System.out.println("Inherited construct...");
    }

    protected Inherited(int count){
        this.count = count;
        System.out.println("Inherited construct with count: " + count);
    }

    /**
     * 此番定义只将数组声明与数组长度声明，并没有将元素构造出来
     */
//    private InheritConstructor[] constructors = new InheritConstructor[4];

    /**
     * 显示如此定义变量，在构造对象时就将成员构造出来
     */
//    private InheritConstructor constructor = new InheritConstructor();


    public static void main(String[] args){
        Inherited inherited = new Inherited(3);
//        System.out.println(inherited.constructors[0]);
//        System.out.println(inherited.constructor);
    }
}
