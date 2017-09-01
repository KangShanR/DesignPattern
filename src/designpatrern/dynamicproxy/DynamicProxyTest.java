/**
 * 
 */
package designpatrern.dynamicproxy;

/**
 * @author Administrator
 *
 */
public class DynamicProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//动态代理的实现
		Draw realDraw = new RealDraw();
		ProxyDraw proxy = new ProxyDraw(realDraw);
		Draw proxyDraw = (Draw)proxy.getProxyIns();
		proxyDraw.draw("....testend");
	}
		
	
}
