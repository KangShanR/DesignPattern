package designpattern.adapterpattern;

/**
 * the adapter
 * @author KangShan
 * @date 2019/11/17 0:30
 */
public class Adapter implements Target {

    Adaptee adaptee = new Adaptee();

	@Override
	public void fly() {
        System.out.println("First, adaptee running ...");
        adaptee.run();
	    System.out.println("Then, let the adaptee fly...........");
	}
}
