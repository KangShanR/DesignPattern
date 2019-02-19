package designpattern.singleton;

/**
 * @description 懒汉式单例模式对象
 * @author KangShan
 * @date 2019/2/19 11:07
 */
public class LazybonesSingleton {

    //饿汉式：提前将实例给实例化好，不会存在线程问题。懒汉式此处不会实例化
    private static LazybonesSingleton instance;


    /**
     * @description 懒汉式双检锁实现线程同步单例
     * @author KangShan
     * @date 2019/2/19 11:08
     */
    public static LazybonesSingleton getInstance(){
        if(instance == null){
            Object lock = new Object();
            synchronized (lock){
                if(instance == null){
                    instance = new LazybonesSingleton();
                }
            }
        }
        return instance;
    }

    /**
     * @description 私有化构造函数
     * @author KangShan
     * @date 2019/2/19 11:09
     */
    private LazybonesSingleton(){
    }

}
