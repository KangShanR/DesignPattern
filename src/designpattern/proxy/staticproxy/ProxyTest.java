package designpattern.proxy.staticproxy;

/**
 * @description
 * @author      KangShan
 * @date        2018/11/22 17:41
 */
public class ProxyTest {

	public static void main(String[] args) {
		RealDraw realDraw = new RealDraw();
		ProxyDraw proxyDraw = new ProxyDraw(realDraw);
		proxyDraw.draw("test");
	}
}
