/**
 * 
 */
package designpatrern.proxy.dynamicproxy;

/**
 * @author Administrator
 */
public class DynamicProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//动态代理的实现
		Draw realDraw = new RealDraw();
		Draw proxyDraw = (Draw)new ProxyDraw(realDraw).getProxyIns2();
		proxyDraw.draw("....test.end");
	}
	
}
