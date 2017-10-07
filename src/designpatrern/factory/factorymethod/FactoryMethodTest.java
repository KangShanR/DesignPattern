package designpatrern.factory.factorymethod;

public class FactoryMethodTest {

	public static void main(String[] args) {

		//创建iphone过程，先建工厂，再在工厂中创建iphone
//		IphoneFactory facIphone = new IphoneFactory();
//		Iphone iphone = facIphone.createPhone();
//		//创建miphone过程：
//		MiphoneFactory facMiphone = new MiphoneFactory();
//		Miphone miphone = facMiphone.createPhone();
		System.out.println('\u0002');
		System.out.println("adgdfa".getBytes()[1]);
		byte a = '0';
		char b = '0';
		System.out.println(a);
		System.out.println((int)'b');
		String c = "C";
		String d = c;
		System.out.println(c);
		System.out.println(d);
		c+="c";
		System.out.println(c);
		System.out.println(d);
		StringBuffer e = new StringBuffer("E");
		StringBuffer f = e;
		System.out.println(e);
		System.out.println(f);
		e.append("e");
		System.out.println(e);
		System.out.println(f);
	}

}
