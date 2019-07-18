package designpattern.singleton;

/**
 * @description 静态内部类实现单例
 * @author KangShan
 * @date 2019/2/19 15:21
 */
public class StaticInnerClassSingleton {

    //私有化构造器
    private StaticInnerClassSingleton(){}

    /**
     * @description 静态内部类
     * @author KangShan
     * @date 2019/2/19 15:31
     */
    private static class InnerClass {
        private static StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance(){
        return InnerClass.INSTANCE;
    }

}
