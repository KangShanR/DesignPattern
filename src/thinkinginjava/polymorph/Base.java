package thinkinginjava.polymorph;

/**
 * @author KangShan
 * @date 2019/11/9 23:15
 */
public class Base {
    int amount = 52;
    Base(){
        this.base();
    }
    void basePrint(){
//        System.out.println("base print");
        base();
    }

    private void basePrivate(){
        System.out.println("base private method");
    }

    void base(){
        System.out.println("base.base(); amount: " + amount);
//        basePrint();
    }

    public static void main(String[] args) {
        Base base = new Exported();
        /**
         * @result "base private method"
         * 动态绑定无效：private 已在编译期 前期绑定了，
         * 后期绑定无效，方法体在编译期就被绑定在本类私有方法上。
         * 所以此处执行了本类的私有方法。
         *
         * 在平常开发中，如果出现导出类重写一个基类私有方法，并在基类中调用该方法，
         * 那么就会调用到基类的私有方法上。
         */
        base.basePrivate();
    }
}
