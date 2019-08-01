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


    @Test
    public void getBytesTest() throws UnsupportedEncodingException {
        byte[] bytes = "abc123我".getBytes("GBK");
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

    void test1() {
        System.out.println("test1 start");
        try {
            System.out.println("test1 execute");
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test1 end");
    }

    void test2() {
        System.out.println("test2 start");
        try {
            System.out.println("test2 execute");
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test2 end");
    }


    public static void main(String[] args){
        final MyTest t = new MyTest();

        new Thread(() -> t.test1()).start();
        new Thread(() -> t.test2()).start();


    }
    

}
