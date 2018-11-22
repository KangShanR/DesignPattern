package designpattern.proxy.staticproxy;

/**
 * @description 静态代理只能简单地让代理实现同一个参数接口，让代理来实现目标的动作
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
