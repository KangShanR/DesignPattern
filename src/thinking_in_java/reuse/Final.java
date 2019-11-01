package thinking_in_java.reuse;

/**
 * @author KangShan
 * @date 2019/11/1 23:27
 */
public class Final {
    final int blank;

    /**
     * 编译器将各个非静态常量都放到了构造器中赋值
     */
    Final(){
        blank = 1;
    }
    Final(int i){
        blank = i;
    }
    final  byte    f = ' ';
//    final  boolean aBoolean = true;
//    static boolean b = false;
    double cDouble  = Math.random();
    double aDouble  = 3.14;
    /**
     * 对于基础数据类型，编译器并不会对其传递引用地址
     * 而是对于已经存在的值不进行赋值，在运行时直接在栈中去找现有的数据
     */
    double bDouble = cDouble;

    /**
     * 使用常量赋值时，编译器并不会对其赋值
     */
    final boolean bBoolean = false;

//    public static final boolean S = true;

    byte d;

    private boolean good(byte f){
        System.out.println(f);
        return true;
    }


    public static void main(String[] args){
        Final aFinal = new Final();
        System.out.println(aFinal.bBoolean);
        System.out.println(aFinal.f);
        aFinal.good(aFinal.d);

    }
}
