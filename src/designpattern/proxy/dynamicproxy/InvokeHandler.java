/**
 * 
 */
package designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author ks
 *
 */
public class InvokeHandler implements InvocationHandler {

	Object obj;
	Enhancer en = new Enhancer();
	public InvokeHandler(Object obj){
		this.obj = obj;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke.start....");
		Object result = method.invoke(obj, args);
		System.out.println("invoke.end....");
		return result;
	}

}
