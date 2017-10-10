package designpattern.factory.abstractfactory;

public class LenovoFactory extends AbstractFactory {

	@Override
	public EngineAmd createEngine() {
		return new EngineAmd();
	}

	@Override
	public NokiaMusic createMusicBox() {
		return new NokiaMusic();
	}

}
