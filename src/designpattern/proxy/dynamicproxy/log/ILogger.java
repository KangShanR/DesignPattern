package designpattern.proxy.dynamicproxy.log;

import java.lang.reflect.Method;

/**
 * @description 日志接口
 * @author KangShan
 * @date 2019/5/21 19:28
 */
public interface ILogger {

    /**
     * @description 方法开始
     * @author KangShan
     * @date 2019/5/21 19:30
     */
    void start(Method method);

    /**
     * @description 方法结束
     * @author KangShan
     * @date 2019/5/21 19:30
     */
    void end(Method method);

}
