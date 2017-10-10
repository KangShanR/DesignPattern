/**
 * 
 */
package designpattern.proxy.cglibproxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author Administrator
 *
 */
public class ProxyFactory implements MethodInterceptor{

	private Object target;
	
	//构造函数中将目标确定
	public ProxyFactory(Object obj){
		this.target = obj;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("开始事务拦截。。。。。。。。");
		Object result = method.invoke(target, args);
		System.out.println("结束事务拦截。。。。。。。。");
		return result ;
	}
	
	/**
	 * 获取代理的方法
	 * @return
	 */
	Object getProxyIns(){
		//增强工具
		Enhancer en = new Enhancer();
		//设置父类
		en.setSuperclass(target.getClass());
		//设置回调函数
		en.setCallback(this);
		//创建子类
		return en.create();
	}
		
}
