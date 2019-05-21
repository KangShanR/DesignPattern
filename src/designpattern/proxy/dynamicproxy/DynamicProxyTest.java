/**
 * 
 */
package designpattern.proxy.dynamicproxy;

import designpattern.proxy.dynamicproxy.log.impl.Logger;

import java.util.Date;

/**
 * @author Administrator
 */
public class DynamicProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		System.out.println(String.format("%03d-%tT%n",1,new Date()));
//		System.out.println(String.format("%b-%012d",true,232));

	    Integer a = 1___1;
//		assert a == 1 : "the a != 1";

		//动态代理的实现
		Draw realDraw = new RealDraw();
		System.out.println("proxyDraw1 .....");
		Draw proxyDraw2 = (Draw)new ProxyDraw(realDraw).getProxyIns2();
        proxyDraw2.draw("drawName");
        System.out.println("proxyDraw1 .....");
		Draw proxyDraw = (Draw)new ProxyDraw().getProxyIns(realDraw, new Logger());
        proxyDraw.draw("drawName");
	}
	
}
