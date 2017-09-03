package designpatrern.factory.abstractfactory;

public class AppleFactory implements AbstractFactory {

	@Override
	public EngineIntel createEngine() {
		return new EngineIntel();
	}

	@Override
	public SonyMusic createMusicBox() {
		return new SonyMusic();
	}

}
