package designpattern.singleton;

/**
 * @description 
 * @author KangShan
 * @date 2019/2/19 11:31
 */
public class HungrySingleton {

    //提前将单例实例化成静态变量而实现不用到使用时再去实例化，也满足了多线程下单例的实现
    private static HungrySingleton instance = new HungrySingleton();

    //私有化构造器
    private HungrySingleton(){}

    //获取方法
    public static HungrySingleton getInstance(){
        return instance;
    }

}
