package thinking_in_java.innerclass.controlframework;

/**
 * @author KangShan
 * @date 2020/1/11 23:10
 */
public abstract class Event {
    long delayTime;
    long eventTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }
    void start() {
        eventTime = System.currentTimeMillis() + delayTime;
    }

    boolean ready() {
        return System.currentTimeMillis() >= eventTime;
    }

    /**
     * 事件动作
     * @date    2020/1/11 23:18
     */
    public abstract void action();
}
