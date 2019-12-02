package java8inaction.parallel;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author KangShan
 * @date 2019/11/30 16:57
 */
public class SpliteratorTest {
    public static void main(String[] args) {
        String    str = "If you miss the train I'm on, you will know that I'm gone.";
        String[]  split = str.split(" ");
//        Arrays.stream(split).forEach(System.out::println);
        System.out.println(
                IntStream.range(0, str.length()).mapToObj(str::charAt)
                .parallel()
                .reduce(
                        new WordCounter(0, true),
                        WordCounter::accumulator,
                        WordCounter::combiner
                ).getCount());

        Spliterator<Character> s      = new WordCountSpliterator(str);
        Stream<Character>      stream = StreamSupport.stream(s, true);
        System.out.println(stream
                .reduce(
                        new WordCounter(0, true),
                        WordCounter::accumulator,
                        WordCounter::combiner).getCount());
    }
}
