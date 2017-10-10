package designpattern.factory.factorymethod;

public class IphoneFactory implements Factory {

	@Override
	public Iphone createPhone() {
		return new Iphone();
	}

}
