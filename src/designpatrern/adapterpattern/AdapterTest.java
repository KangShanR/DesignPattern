package designpatrern.adapterpattern;

public class AdapterTest {

	public static void main(String[] args) {
		Adapter adaptee = new Adapter();
		adaptee.fly();
		adaptee.run();
	}
	
}
