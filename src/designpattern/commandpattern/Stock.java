/**
 * 
 */
package designpattern.commandpattern;

/**
 * @author Administrator
 * 用买卖股本的例子来简单说明命令模式的原理
 * 股票类
 */
public class Stock {

	private int quantity;
	private String name;
	
	/**
	 * 默认构造函数
	 */
	public Stock() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 重载构造函数
	 */
	public Stock(int quantity, String name) {
		// TODO Auto-generated constructor stub
		this.quantity = quantity;
		this.name = name;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
