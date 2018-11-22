/**
 * 
 */
package designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println("Proxy_start");
						Object returnValue = method.invoke(target, args);
						System.out.println("Proxy_end");
						return returnValue;
					}
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
