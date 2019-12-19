package java8inaction.function;

/**
 * 函数式编程
 * 对于极致的函数式编程：任何时间任何地点对于同样参数请求一个函数方法，应该返回同一个结果。
 * 这就要求了函数不对外部数据进行更改，就算有，也不能暴露给外部调用者。
 * @author KangShan
 * @date 2019/12/19 22:56
 */
public class FunctionOptimization {
    /**
     * 使用递归代替 for/while 循环体，因为这两者的每一次迭代都会对数据更新再作为判定是否进入下一次
     * 循环的条件。
     * 与此同时，递归存在的问题在于：虽然其实现形式更清晰明了，但其每一次循环都会增加一层栈帧，
     * 增加内存消耗。解决这一问题的思路是: tail-call optimization 尾调优化。
     * 所谓尾调优化是指每次调用同一方法时，参数都在方法中，方法体保持一致，编译器就会使用同一栈帧，
     * 从而达到减少内存消耗的效果，但目前 java 未实现此优化（scala/groovy 已实现）。
     */
    static long factorialIterative(long n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static long factorialRecursive(long n) {
        return n == 1 ? 1 : factorialRecursive(n - 1) * n;
    }

    /**
     * 目前 java compiler 并未实现 tail call optimization ，所以这种实现依然是递归
     * @author  KangShan
     * @param   res 局部结果
     * @return  long
     * @date    2019/12/19 23:17
     */
    static long factorialTailCall(long res, long n) {
        return n == 1 ? res:factorialTailCall(n*res, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorialTailCall(1, 11));
        System.out.println(factorialRecursive(11));
        System.out.println(factorialIterative(12));
    }

}
