package java8inaction.stream.muiltipleoperate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author KangShan
 * @date 2019/12/26 1:51
 */
public class MultiOperateStreamTest {

    public static void forkStream() {
        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>();
        queue.add("good");
        queue.add("morning");
        queue.add("afternoon");
        queue.add(StreamForker.ForkingStreamConsumer.STREAM_END);
        Stream<String> stream = StreamSupport.stream(new BlockingQueueSpliterator(queue), false);
        stream.forEach(System.out::println);
        Stream<String> stream2 = StreamSupport.stream(new BlockingQueueSpliterator(queue), false);
        System.out.println(stream2.findFirst().get());

    }

    public static void iterator(String[] args) {
        List<String>      strs = Arrays.stream(args).collect(Collectors.toList());
        Iterator<String> iterator = strs.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        iterator.remove();
    }

    public static void main(String[] args) {
        String[] strs = {"1","2","23","kang", "shan", "ssr"};
        Stream<String> stream = Arrays.stream(strs);
        StreamForker.Results results = new StreamForker<>(stream)
                .fork("1", s -> s.filter(i -> i.length() > 3).collect(Collectors.joining(";")))
                .fork("2", s -> s.filter(i -> i.length() > 0).collect(Collectors.joining(";")))
                .fork("17", s -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    return s.filter(i -> i.length() < 3).collect(Collectors.joining(";"));})
                .fork("14", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
                .fork("15", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
                .fork("16", s -> s.filter(i -> i.length() < 3).collect(Collectors.joining(";")))
                .getResults();
        System.out.println(results.get("1").toString());
        System.out.println(results.get("2").toString());
        System.out.println(" 17: " + results.get("17").toString());
//        forkStream();
    }
}
