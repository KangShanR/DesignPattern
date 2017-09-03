/**
 * 
 */
package designpatrern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author Administrator
 *
 */
public class InvokeHandler implements InvocationHandler {

	Object obj;
	Enhancer en = new Enhancer();
	public InvokeHandler(Object obj){
		this.obj = obj;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke.start....");
		Object resultValue = method.invoke(obj, args);
		System.out.println("invoke.end....");
		return resultValue;
	}

}
