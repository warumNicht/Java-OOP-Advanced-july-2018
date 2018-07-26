package p01_system_resources;

import p01_system_resources.interfaces.GreetingClock;
import p01_system_resources.interfaces.TimeProvider;
import p01_system_resources.interfaces.Writer;
import p01_system_resources.models.GreetingClockImpl;
import p01_system_resources.models.TimeProviderImpl;
import p01_system_resources.models.WriterImpl;

public class Main {
    public static void main(String[] args) {
        TimeProvider provider=new TimeProviderImpl();
        Writer writer=new WriterImpl();
        GreetingClock clock=new GreetingClockImpl(provider,writer);

        clock.greet();
    }
}
