/**
 * 
 */
package designpattern.commandpattern;

/**
 * @author Administrator
 * 购买股票的类，实现命令接口
 */
public class BuyStock implements Order {

	/**	购买购票数量 */
	private int quantity;
	private Stock stock;
	
	/**
	 * 构造函数
	 */
	public BuyStock() {
	}
	/**
	 * 带参构造函数
	 */
	public BuyStock(int quantity,Stock stock) {
		this.quantity = quantity;
		this.stock = stock;
	}

	@Override
	public void execute() {
		this.stock.setQuantity(this.stock.getQuantity()+this.quantity);
		System.out.println("BuyStock:"+this.stock.getName()+"  quantity:"+this.quantity+"  result:"+this.stock.getQuantity());
	}

}
