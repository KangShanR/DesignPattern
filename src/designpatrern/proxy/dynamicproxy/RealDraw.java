/**
 * 
 */
package designpatrern.proxy.dynamicproxy;

/**
 * @author Administrator
 *
 */
public class RealDraw implements Draw {

	@Override
	public void draw(String name) {

		System.out.println("RealDraw.draw"+name);
	}

}
