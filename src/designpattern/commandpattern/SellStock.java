/**
 * 
 */
package designpattern.commandpattern;

/**
 * @author Administrator
 * 售卖股票的类，同样实现Order接口
 */
public class SellStock implements Order {

	private int quantity;
	private Stock stock;
	/**
	 * 构造函数
	 */
	public SellStock() {
	}
	/**
	 * 构造函数
	 */
	public SellStock(int quantity, Stock stock) {
		this.quantity = quantity;
		this.stock = stock;
	}

	/* (non-Javadoc)
	 */
	@Override
	public void excute() {
		this.stock.setQuantity(this.stock.getQuantity()-this.quantity);
		System.out.println("SellStock:"+this.stock.getName()+"  quantity:"+ this.quantity +"  result:"+this.stock.getQuantity());
	}

}
