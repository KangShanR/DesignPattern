package designpattern.adapterpattern;

/**
 * 适配器模式
 * 顾名思义，适配器是将原本不能适配的物件经过适配器处理后能够适配到指定的地方。
 *
 * 现实举例：一个美国产的手机充电器插头，来到大陆并不能适配这儿的插座。
 * 这个时候就出现了适配器，将充电器插头插到适配器上，再将适配器插到我们大陆的插座上，
 * 就实现了美产充电器在大陆充电的功能。
 *
 * 而在 《Thinking in Java》 中文第四版 p177 中，明显能看出来，这儿的例子是，
 * 想要用被适配者的功能，但被适配者并未实现需要的接口，这个时候让适配器来实现这个接口，
 * 并在接口方法实现中使用被适配者的方法功能。
 * @author KangShan
 * @date 2019/11/17 0:06
 */
public class AdapterTest {

    static void needFly(Target target){
        target.fly();
    }

	public static void main(String[] args) {
        needFly(new Adapter());
	}
	
}
