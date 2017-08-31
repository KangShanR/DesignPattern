/**
 * 
 */
package designpatrern.proxy;

/**
 * @author Administrator
 *
 */
public class ProxyDraw implements Draw {

	RealDraw realDraw;
	
	/* (non-Javadoc)
	 * @see designpatrern.proxy.Draw#draw(java.lang.String)
	 */
	@Override
	public void draw(String name) {

		if(realDraw == null){
			realDraw = new RealDraw();
		}
		realDraw.draw(name);
	}

}
