package designpattern.factory.abstractfactory;

public class AppleFactory extends AbstractFactory {

	@Override
	public EngineIntel createEngine() {
		return new EngineIntel();
	}

	@Override
	public SonyMusic createMusicBox() {
		return new SonyMusic();
	}

}
