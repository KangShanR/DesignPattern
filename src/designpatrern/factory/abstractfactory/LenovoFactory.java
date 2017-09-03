package designpatrern.factory.abstractfactory;

public class LenovoFactory implements AbstractFactory {

	@Override
	public EngineAmd createEngine() {
		return new EngineAmd();
	}

	@Override
	public NokiaMusic createMusicBox() {
		return new NokiaMusic();
	}

}
