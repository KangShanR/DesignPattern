/**
 * 
 */
package designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.stream.Stream;

/**
 * @author Administrator
 * 动态代理
 */
public class ProxyDraw {

	Object target;
	
	public ProxyDraw(Object target){
		this.target = target;
	}
	
	/* 
	 * 使用匿名内部类，获取代理实例
	 * @see designpatrern.dynamicproxy.Draw#draw(java.lang.String)
	 */
	public Object getProxyIns() {
		System.out.println("ProxyDraw.getProxyIns...............");
        return Proxy.newProxyInstance(
		        target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
                (proxy, method, args) -> {
//                    System.out.println(proxy.toString());     //此行代码将产生递归调用生成代理而出现内存溢出，
                                                                // 所以此处的 proxy 就是此处实现的本身 **此处有疑问**
                    System.out.println("Proxy_start");
                    System.out.println("method:" + method.getName());
                    Stream.of(args).forEach(a -> System.out.println("arg:" + a));
                    Object result = method.invoke(this.target, args);
                    System.out.println("Proxy_end");
                    return result;
                });
	}
	/* 
	 * 提取匿名内部类出来获取代理实例的方法
	 * @see designpatrern.dynamicproxy.Draw#draw(java.lang.String)
	 */
	public Object getProxyIns2() {
		System.out.println("ProxyDraw.getProxyIns2...............");
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new InvokeHandler(this.target)); 
	}
}
