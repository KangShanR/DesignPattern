/**
 * 
 */
package designpattern.commandpattern;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

/**
 * @author Administrator
 * 购买股票的类，实现命令接口
 */
@Slf4j
@Data
@NoArgsConstructor
public class BuyStock implements Order {

	/**	购买购票数量 */
	private int quantity;
	/**	股票 */
	private Stock stock;

	/**
	 * 带参构造函数
	 */
	public BuyStock(int quantity, Stock stock) {
        Assert.notNull(stock, "Stock is null.");
        log.info("Buy {} stock, quantity: {}", stock.getName(), quantity);
		stock.setQuantity(stock.getQuantity() + quantity);
		this.stock = stock;
	}

}
