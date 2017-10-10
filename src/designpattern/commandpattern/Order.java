/**
 * 
 */
package designpattern.commandpattern;

/**
 * @author Administrator
 * 命令接口，命令模式中实现多条命令都得实现此接口，也就是利用依赖倒置而将众多本来不相干的命令全都用此接口联系在一起，
 * 	这样就可以将命令通过依赖的接口串接在一个链（在这儿使用List的数据结构）中
 */
public interface Order {

	void excute();
}
