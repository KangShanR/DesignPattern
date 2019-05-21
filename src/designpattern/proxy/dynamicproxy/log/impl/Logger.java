package designpattern.proxy.dynamicproxy.log.impl;

import designpattern.proxy.dynamicproxy.log.ILogger;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @description
 * @author KangShan
 * @date 2019/5/21 19:32
 */
@Slf4j
public class Logger implements ILogger {


    public void start(Method method) {
        System.out.println("method: " + method.getName() + " start ...");
        log.info("method: " + method.getName() + " start ...");
    }

    public void end(Method method) {
        System.out.println("method ：" + method.getName() + " end ...");
        log.info("method " + method.getName() + " end ...");
    }
}
