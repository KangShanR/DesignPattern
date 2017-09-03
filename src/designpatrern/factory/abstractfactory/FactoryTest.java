/**
 * 
 */
package designpatrern.factory.abstractfactory;

/**
 * @author Administrator
 *
 */
public class FactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Apple apple4s = new Apple();
		Lenovo lenovo3 = new Lenovo();
		//apple生产过程
		AbstractFactory appleFactory = new AppleFactory();
		apple4s.engine=appleFactory.createEngine();
		apple4s.musicBox=appleFactory.createMusicBox();
		//Lenovo生产过程
		LenovoFactory lenovoFactory = new LenovoFactory();
		lenovo3.engine=lenovoFactory.createEngine();
		lenovo3.musicBox=lenovoFactory.createMusicBox();
	}

}
