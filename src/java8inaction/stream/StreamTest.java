package java8inaction.stream;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author KangShan
 * @date 2019/11/23 0:20
 */
@Slf4j
public class StreamTest{
    public static void main(String[] args) {
        /**
         * stream.of factory method
         */
        //        IntStream ints= IntStream.of(1, 32,3,324,543,234);
        /**
         * value stream from range
         */
        IntStream range = IntStream.range(1, 222);
        System.out.println(range.max());

        System.out.println(IntStream.range(0,512)
                .boxed()
                .collect(Collectors.maxBy(Comparator.comparingInt(Integer::intValue))));
        System.out.println(IntStream.range(0, 512)
                .boxed().max(Comparator.comparingInt(Integer::intValue))
                .get());

        IntSummaryStatistics sumStatistics = IntStream.range(0, 256).summaryStatistics();
        System.out.println(sumStatistics.toString());

        IntStream.range(0, 128).boxed()
                .collect(Collectors.reducing(Integer::sum));
//                .reduce()

        /**
         * int stream mapping to object stream
         */
//        ints.mapToObj(i -> new IntObj(i))
//                .peek(System.out::print)
//                .max(Comparator.comparing(IntObj::getI))
//                .get().toString();

        /**
         * file stream
         */
//        try(Stream<String> lines = Files.lines(
// Paths.get("H:\\programming\\projects\\DesignPattern\\src\\java8inaction\\stream/file"),
//                            Charset.defaultCharset())){
//            lines.forEach(System.out::println);
//        }catch (IOException e){
//            log.error("io error",e);
//        }

        /**
         * infinity stream in fibbonachi
         */
//        Stream.iterate(new int[]{0,1}, i -> new int[]{i[1], i[1] + i[0]})
//                .limit(20)
//                .forEach(i -> log.info(i[0] + " " + i[1]));
    }
}
