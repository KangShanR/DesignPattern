package designpattern.proxy.cglibproxy;

public class CglibProxyTest {

	public static void main(String[] args) {
		Target target = new Target();
		Target2 target2 = new Target2();
		target2 = (Target2)new ProxyFactory(target2).getProxyIns();
		target2.targetMethod();
	}
}
