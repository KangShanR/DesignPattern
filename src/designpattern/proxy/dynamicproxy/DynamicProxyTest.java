/**
 * 
 */
package designpattern.proxy.dynamicproxy;

/**
 * @author Administrator
 */
public class DynamicProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	    Integer a = 1___1;
		assert a == 1 : "the a != 1";

		//动态代理的实现
		Draw realDraw = new RealDraw();
//		Draw proxyDraw = (Draw)new ProxyDraw(realDraw).getProxyIns2();
		Draw proxyDraw = (Draw)new ProxyDraw(realDraw).getProxyIns();
		proxyDraw.draw("....test.end");
	}
	
}
