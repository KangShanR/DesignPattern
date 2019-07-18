/**
 *
 */
package designpattern.proxy.staticproxy;

/**
 * 静态代理的实现，代理实现被代理对象的同一个接口
 * @author ks
 */
public class ProxyDraw implements Draw {

	RealDraw realDraw;
    private Object object;

    public ProxyDraw (RealDraw draw){
		this.realDraw = draw;
	}

	@Override
	public void draw(String name) {
		System.out.println("代理开始执行目标动作……");
		realDraw.draw(name);
        System.out.println("代理结束");
    }

}
