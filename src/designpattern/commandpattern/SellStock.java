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
 * 售卖股票的类，同样实现Order接口
 */
@Slf4j
@Data
@NoArgsConstructor
public class SellStock implements Order {

	private int quantity;
	private Stock stock;

	/**
	 * 构造函数
	 */
	public SellStock(int quantity, Stock stock) {
        Assert.notNull(stock, "Stock is null.");
        log.info("Sell {} stock, quantity: {}", stock.getName(), quantity);
        int result = stock.getQuantity() - quantity;
        if(result < 0){
            log.error("Insufficient stock. Quantity of Stock: {}, quantity of be sold: {}", quantity);
            throw new RuntimeException("Insufficient stock.");
        }
        stock.setQuantity(result);
        this.stock = stock;
	}


}
