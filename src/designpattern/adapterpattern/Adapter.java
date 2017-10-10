package designpattern.adapterpattern;

public class Adapter extends Adaptee implements Target {


	@Override
	public void run() {
		super.run();
		System.out.println("Adapter.run.......");
	}

	@Override
	public void fly() {
		System.out.println("Adapter.fly...........");
	}
}
