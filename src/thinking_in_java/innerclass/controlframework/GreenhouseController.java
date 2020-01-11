package thinking_in_java.innerclass.controlframework;

/**
 * @author KangShan
 * @date 2020/1/11 23:19
 */
public class GreenhouseController extends Controller{
    boolean light;

    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            System.out.println("Turn the light on");
            light = true;
        }
    }
    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            System.out.println("Turn the light off");
            light = false;
        }
    }

    public class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            System.out.println("Turn down");
            System.exit(1);
            System.out.println("over");
        }
    }

    public static void main(String[] args) {
        GreenhouseController gc = new GreenhouseController();
        Event[] events = new Event[]{
                gc.new LightOn(1000L),
                gc.new LightOff(3000L),
                gc.new Terminate(10000L),
        };
        gc.addEvent(events[0]);
        gc.addEvent(events[1]);
        gc.addEvent(events[2]);
        gc.run();
    }
}
