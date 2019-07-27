package designpattern.singleton;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @description
 * @author KangShan
 * @date 2019/2/19 15:36
 */
@Slf4j
public class MyTest {

    /**
     * @author KangShan
     * @return void
     * @see // FIXME: 2019/7/27
     * @date 2019/7/27
     * @param args
     */
    public static void main(String[] args){
        System.out.println(args.length);
        Arrays.stream(args).forEach(System.out::println);
        final String s;
        s = "dfd";

        System.getProperties().list(System.out);

    }

    @Test
    public void getBytesTest() throws UnsupportedEncodingException {
        byte[] bytes = "abc123".getBytes("GBK");
        for(int i = 0; i < bytes.length; i++){
            System.out.println(bytes[i]);
        }
        System.out.println(new String(bytes, Charset.forName("GBK")));
    }

    @Test
    public void mapEntryTest() {
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();

        Set<Map.Entry<String, Charset>> entries = stringCharsetSortedMap.entrySet();
        Iterator<Map.Entry<String, Charset>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Charset> next = iterator.next();
            log.info("key:" + next.getKey());
            log.info("name:" + next.getValue().name());
        }
    }


}
