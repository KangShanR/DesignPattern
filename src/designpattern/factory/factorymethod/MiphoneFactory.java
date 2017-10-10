package designpattern.factory.factorymethod;

public class MiphoneFactory implements Factory {

	@Override
	public Miphone createPhone() {
		return new Miphone();
	}
}