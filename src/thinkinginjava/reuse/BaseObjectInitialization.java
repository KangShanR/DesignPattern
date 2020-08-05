package thinkinginjava.reuse;

/**
 * @author KangShan
 * @date 2019/11/3 23:33
 */
public class BaseObjectInitialization {
    static {
        System.out.println("base static block ... ");
    }
    static int j = assign(3);

    int i = assign(1);

    static int assign(int i){
        System.out.println("assigning : " + i);
        return i;
    }

    BaseObjectInitialization(){
        System.out.println("base construct");
    }

    public static void main(String[] args) {
        new BaseObjectInitialization();
    }
}
