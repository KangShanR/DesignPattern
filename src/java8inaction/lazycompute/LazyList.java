package java8inaction.lazycompute;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author KangShan
 * @date 2019/12/22 22:31
 */
@AllArgsConstructor
public class LazyList<T> {
    @Getter
    T head;
    Supplier<LazyList<T>> tailSupplier;

    LazyList(T t) {
        this.head = t;
    }


    LazyList<T> getTail() {
        return tailSupplier.get();
    }

    /**
     * lambda 表达式将延迟计算，只有当要使用到 lambda 计算时才会执行 lambda 代码，
     * i 只执行到 i 不计算其 tail 时，就会只执行到 lambda 代码
     *
     * @param i parameter
     * @return java8inaction.lazycompute.LazyList<java.lang.Integer>
     * @author KangShan
     * @date 2019/12/22 23:09
     */
    static LazyList<Integer> from(int i) {
        return new LazyList<>(i,
                () -> from(i + 1));
    }

    /**
     * 形成递归，运行将产生 StackOverflowError
     *
     * @param i parameter
     * @return java8inaction.lazycompute.LazyList<java.lang.Integer>
     * @author KangShan
     * @date 2019/12/22 22:57
     */
    static LazyList<Integer> from2(int i) {
        return from2(i + 1);
    }

    LazyList<T> filter(Predicate<T> predicate) {
        return this.head == null ?
                this :
                predicate.test(getHead()) ?
                        new LazyList<>(getHead(),
                                () -> getTail().filter(predicate)) :
                        getTail().filter(predicate);
    }

    static LazyList<Integer> primes(LazyList<Integer> numbers) {
        return new LazyList<>(numbers.head, () -> primes(numbers.getTail().filter(
                n -> n% numbers.getHead() != 0
        )));
    }

    /**
     * java 中未实现  tail call optimization ，不能对此递归调用进行优化，将出现  StackOverflowError
     * @author  KangShan
     * @param   list 延迟列表
     * @return  void
     * @date    2019/12/23 0:06
     */
    static <T>void printAll(LazyList<T> list) {
        if (list != null) {
            System.out.println(list.getHead());
        }
        printAll(list.getTail());
    }

    public static void main(String[] args) {
        LazyList<Integer> from = from(2);
        System.out.println(primes(from).getHead());
        System.out.println(primes(from).getTail().head);
        System.out.println(primes(from).getTail().getTail().getHead());

        printAll(primes(from));

    }

}
