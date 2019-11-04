package thinking_in_java.reuse;

/**
 * 值传递与引用传递的区别
 * @author KangShan
 * @date 2019/11/3 22:45
 */
public class AddressVsValueTransfer {

    int i;
    AddressVsValueTransfer a;

    {
        System.out.println("auto construct");
        /**
         * 递归
         */
        //        a = new AddressVsValueTransfer();
    }

    static void assign(int i){

        i++;
        System.out.println(i);
    }

    public static void main(String [] args){
        AddressVsValueTransfer addressVsValueTransfer = new AddressVsValueTransfer() {
            {
                i = 222;
            }
        };
        System.out.println(addressVsValueTransfer.i);
        int i = 1;
        assign(i);
        System.out.println(i);
    }

}
