package designpatrern.proxy;

public class RealDraw implements Draw {

	@Override
	public void draw(String name) {

		System.out.println(name+".RealDraw...........");
	}

}
