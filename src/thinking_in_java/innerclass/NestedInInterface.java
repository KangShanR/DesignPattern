package thinking_in_java.innerclass;

/**
 * @author KangShan
 * @date 2019/11/18 23:36
 */
public interface NestedInInterface {
    /**
     * the main method in interface
     * @param args
     */
    static void main(String[] args){
        System.out.println("interface main method");
    }

    class Nested{

        {
            System.out.println("nested class in NestedInInterface");
        }
        public static void main(String[]args){

        }

    }
}
