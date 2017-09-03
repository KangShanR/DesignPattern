package designpatrern.proxy.staticproxy;

public class ProxyTest {

	public static void main(String[] args) {
		RealDraw realDraw = new RealDraw();
		ProxyDraw proxyDraw = new ProxyDraw(realDraw);
		proxyDraw.draw("test");
	}
}
