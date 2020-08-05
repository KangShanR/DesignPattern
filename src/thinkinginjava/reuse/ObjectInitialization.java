package thinkinginjava.reuse;

/**
 * @author KangShan
 * @date 2019/11/3 23:33
 */
public class ObjectInitialization extends BaseObjectInitialization{
//    static {
//        System.out.println("static block ...");
//    }
//    static int j = assign(33);

    int i = assign(11);

    ObjectInitialization(){

    }

    public static void main(String[] args) {

        System.out.println("construct ...");
        ObjectInitialization objectInitialization = new ObjectInitialization();
//        new BaseObjectInitialization();
        System.out.println("construct end");

    }
}
