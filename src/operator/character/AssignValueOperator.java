package operator.character;

/**
 * @author KangShan
 * @date 2019/8/9 12:38
 */
public class AssignValueOperator {

    static StringBuilder builderStr(StringBuilder s){
        s = new StringBuilder("Ipad");
        return s;
    }

    public static void main(String[] args){
        StringBuilder s = new StringBuilder("Iphone");
        System.out.println(s);
        System.out.println(builderStr(s).toString());
    }
}
