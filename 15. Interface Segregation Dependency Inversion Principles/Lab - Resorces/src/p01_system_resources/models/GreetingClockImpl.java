package p01_system_resources.models;

import p01_system_resources.interfaces.GreetingClock;
import p01_system_resources.interfaces.TimeProvider;
import p01_system_resources.interfaces.Writer;

import java.time.LocalTime;

public class GreetingClockImpl implements GreetingClock {

    private TimeProvider time;
    private Writer writer;

    public GreetingClockImpl(TimeProvider time, Writer writer) {
        this.time = time;
        this.writer = writer;
    }

    @Override
    public void greet() {
        if (time.getHour() < 12) {
            System.out.println("Good morning...");
        } else if (time.getHour() < 18) {
            System.out.println("Good afternoon...");
        } else {
            System.out.println("Good evening...");
        }
    }
}
