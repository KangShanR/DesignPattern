package designpattern.factory.factorymethod;

/**
 * @Description 工厂方法模式：让构造 bean 的事情都交给工厂来做
 * @Author KangShan
 * @CreateDate 2018/11/22 18:48
 */
public class FactoryMethodTest {

	public static void main(String[] args) {

		//创建iphone过程，先建工厂，再在工厂中创建iphone
		IphoneFactory facIphone = new IphoneFactory();
		Iphone iphone = facIphone.createPhone();
		//创建miPhone过程：
		MiphoneFactory facMiPhone = new MiphoneFactory();
		MiPhone        miphone    = facMiPhone.createPhone();
		
	}

}
