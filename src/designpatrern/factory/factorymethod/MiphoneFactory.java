package designpatrern.factory.factorymethod;

public class MiphoneFactory implements Factory {

	@Override
	public Miphone createPhone() {
		return new Miphone();
	}
}