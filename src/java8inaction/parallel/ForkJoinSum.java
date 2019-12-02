package java8inaction.parallel;

import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 分支合并求和
 *
 * @author KangShan
 * @date 2019/11/30 9:07
 */
public class ForkJoinSum extends RecursiveTask<Long> {
    private static final int    THRESHOLD = 100;
    private final        long[] numbers;
    private final        int    start;
    private final        int    end;

    public ForkJoinSum(long[] numbers) {
        this.numbers = numbers;
        this.start = 0;
        this.end = numbers.length;
    }

    public ForkJoinSum(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            return computeSequentially();
        }
        ForkJoinSum left = new ForkJoinSum(numbers, start, (end + start) / 2);
        left.fork();
        ForkJoinSum right       = new ForkJoinSum(numbers, (start + end) / 2, end);
        Long        rightResult = right.compute();
        return rightResult + left.join();
    }

    private long computeSequentially() {
        long result = 0;
        for (int i = start; i < end; i++) {
            result += numbers[i];
        }
        return result;
    }

    private static void longStreamSum() {
        long start = System.currentTimeMillis();
        System.out.println("LongStream sum start:" + start);
        System.out.println("LongStream result:" + LongStream.range(0, 10_000_000).sum());
        System.out.println("LongStream sum cost time:" + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
        long curr    = System.currentTimeMillis();
        Long compute = new ForkJoinSum(LongStream.range(0, 10_000_000).toArray()).compute();
        System.out.println("result:" + compute);
        System.out.println("used time in ms:" + (System.currentTimeMillis() - curr));

        longStreamSum();
    }
}
