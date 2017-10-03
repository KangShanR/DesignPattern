/**
 * 
 */
package designpatrern.commandpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * 经纪人类，负责股票的买卖，命令模式实现的类，将买卖股票的所有命令都按序放在经纪人这儿，开成命令链，最终将整条命令链的执行
 */
public class Broker {

	List<Order> orders = new ArrayList<Order>();
	Stock stock = new Stock(100,"Alibaba");
	/**
	 * 构造函数
	 */
	public Broker() {
//		将买与卖股票的命令加入到命令链条中
		orders.add(new BuyStock(10,stock));
		orders.add(new SellStock(1,stock));
//		遍历命令链，并依次执行各个命令
		for(Order order:orders){
			order.excute();
		}
	}
	
//	测试
	public static void main(String[] args) {
		Broker broker = new Broker();
	}

}
