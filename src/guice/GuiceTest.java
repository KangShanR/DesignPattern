package guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceTest {
    public static void main(String[] args) {
        Injector  injector = Guice.createInjector(b -> b.bind(Interface.class).to(IntImpl.class));
        Interface instance = injector.getInstance(Interface.class);
        System.out.println(instance.get());
    }
}
