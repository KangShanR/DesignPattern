/**
 * 
 */
package designpatrern.dynamicproxy;

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
	 * 获取代理实例
	 * @see designpatrern.dynamicproxy.Draw#draw(java.lang.String)
	 */
	public Object getProxyIns() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println("Porxy_start");
						Object returnValue = method.invoke(target, args);
						System.out.println("Porxy_end");
						return returnValue;
					}
				});
	}
}
