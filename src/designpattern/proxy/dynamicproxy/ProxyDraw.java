/**
 * 
 */
package designpattern.proxy.dynamicproxy;

import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * 动态代理
 */
@NoArgsConstructor
public class ProxyDraw {

	Object target;
	Object proxyOpr;

	public ProxyDraw(Object target){
		this.target = target;
	}
	
	/* 
	 * 使用匿名内部类，获取代理实例
	 */
	public Object getProxyIns(Object target, Object proxyOpr) {
		System.out.println("ProxyDraw.getProxyIns...............");
		this.target = target;
		this.proxyOpr = proxyOpr;
        return Proxy.newProxyInstance(
		        target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
                (proxy, method, args) -> {
//                    System.out.println(proxy.toString());     // 此行代码将产生递归调用生成代理
                                                                // 而出现内存溢出，
                                                                // 所以此处的 proxy 就是此处实现的本身
                                                                // **此处有疑问**
                    Class<?> clazz = this.proxyOpr.getClass();
                    Method   start = clazz.getDeclaredMethod("start", Method.class);
                    start.invoke(this.proxyOpr, method);
                    Object result = method.invoke(this.target, args);
                    Method   end  = clazz.getDeclaredMethod("end", Method.class);
                    end.invoke(this.proxyOpr, method);
                    return result;
                });
	}


	/* 
	 * 提取匿名内部类出来获取代理实例的方法
	 */
	public Object getProxyIns2() {
		System.out.println("ProxyDraw.getProxyIns2...............");
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
				new InvokeHandler(this.target)); 
	}
}
