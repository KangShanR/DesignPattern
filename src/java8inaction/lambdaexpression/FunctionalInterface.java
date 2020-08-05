package java8inaction.lambdaexpression;

/**
 * @author KangShan
 * @date 2019/11/19 1:51
 */
public interface FunctionalInterface {
    /**
     * test for method reference in constructor
     * @param i
     * @param j
     * @param o
     * @return
     */
    FunctionalInterfaceTest test(int i, String j, Object o);

    static void main(String[] args) {

        System.out.println();
    }
}
