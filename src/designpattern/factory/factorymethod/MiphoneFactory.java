package designpattern.factory.factorymethod;

public class MiphoneFactory implements Factory {

	@Override
	public MiPhone createPhone() {
		return new MiPhone();
	}
}