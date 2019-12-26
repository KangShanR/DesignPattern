package java8inaction.lazycompute;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 延迟计算的链表
 * @author KangShan
 * @date 2019/12/22 22:31
 */
@AllArgsConstructor
public class LazyList<T> {
    /**
     * 链表当前节点数据
     */
    @Getter
    T head;

    Supplier<LazyList<T>> tailSupplier;

    /**
     * 使用 lambda supply 链表尾部数据
     * @return  java8inaction.lazycompute.LazyList<T>
     * @date    2019/12/26 14:34
     */
    LazyList<T> getTail() {
        return tailSupplier.get();
    }

    /**
     * lambda 表达式将延迟计算，只有当要使用到 lambda 计算时才会执行 lambda 代码，
     * i 只执行到 i 不计算其 tail 时，就会只执行到 lambda 代码
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
     * @param i parameter
     * @return java8inaction.lazycompute.LazyList<java.lang.Integer>
     * @author KangShan
     * @date 2019/12/22 22:57
     */
    @Deprecated
    static LazyList<Integer> from2(int i) {
        return from2(i + 1);
    }

    /**
     * 过滤器对链表所有的数据进行过滤
     * @param   predicate 谓词
     * @return  java8inaction.lazycompute.LazyList<T>
     * @date    2019/12/26 14:32
     */
    LazyList<T> filter(Predicate<T> predicate) {
        return this.head == null ?
                this :
                predicate.test(getHead()) ?
                        new LazyList<>(getHead(),
                                () -> getTail().filter(predicate)) :
                        getTail().filter(predicate);
    }

    /**
     * 计算素数
     * @param   prime 素数链表
     * @return  java8inaction.lazycompute.LazyList<java.lang.Integer>
     * @date    2019/12/26 14:32
     */
    static LazyList<Integer> primes(LazyList<Integer> prime) {
        return new LazyList<>(prime.head,
                () -> primes(prime.getTail()
                        .filter(n -> n % prime.getHead() != 0))
        );
    }

    /**
     * java 中未实现  tail call optimization ，不能对此递归调用进行优化，将出现  StackOverflowError
     * @author  KangShan
     * @param   list 延迟列表
     * @date    2019/12/23 0:06
     */
    static <T>void printAll(LazyList<T> list) {
        if (list != null) {
            System.out.println(list.getHead());
        }
        printAll(list.getTail());
    }

    public static void main(String[] args) {
        LazyList<Integer> head = from(2);
        System.out.println(primes(head).getHead());
        System.out.println(primes(head).getTail().head);
        System.out.println(primes(head).getTail().getTail().getHead());

//        printAll(primes(head));

    }

}
