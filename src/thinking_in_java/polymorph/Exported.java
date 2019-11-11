package thinking_in_java.polymorph;

/**
 * @author KangShan
 * @date 2019/11/9 23:16
 */
public class Exported extends Base {
    int amount = 1;
    Exported(){
        System.out.println("Exported constructor. amount:" + amount);
    }
    @Override
    void base(){
        System.out.println("exported " + amount);
    }
    void basePrivate(){
        System.out.println("exported private");
    }

//    void basePrint(){
//        System.out.println("exported print");
//    }

    public static void main(String[] args) {
        /**
         * @result 0
         * 域的访问会访问到基类中去，并不会动态绑定到对象所在的域，
         * 此时为了区分访问到对象/基类的域，应该使用 this/super 加以描述。
         */
        Base ins = new Exported();
        System.out.println(ins.amount);
//        ins.base();
//        ins.basePrint();
//        ((Exported) ins).basePrivate();
    }
}
