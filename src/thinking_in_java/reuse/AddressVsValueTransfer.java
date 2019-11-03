package thinking_in_java.reuse;

/**
 * 值传递与引用传递的区别
 * @author KangShan
 * @date 2019/11/3 22:45
 */
public class AddressVsValueTransfer {


    static void assign(int i){
        i++;
        System.out.println(i);
    }

    public static void main(String [] args){
        int i = 1;
        assign(i);
        System.out.println(i);
    }

}
