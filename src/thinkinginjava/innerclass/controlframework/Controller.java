package thinkinginjava.innerclass.controlframework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KangShan
 * @date 2020/1/11 23:27
 */
public class Controller {
    List<Event> events = new ArrayList<>();

    void addEvent(Event event) {
        events.add(event);
    }

    void run(){
        while (events.size() > 0) {
            for (Event e : new ArrayList<>(events)) {
                if (e.ready()) {
                    e.action();
                    events.remove(e);
                }
            }
        }
    }
}
