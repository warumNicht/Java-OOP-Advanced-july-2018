package p01_system_resources.models;

import p01_system_resources.interfaces.TimeProvider;

import java.time.LocalTime;

public class TimeProviderImpl implements TimeProvider {
    private LocalTime time;

    public TimeProviderImpl() {
        this.time = LocalTime.now();
    }

    @Override
    public int getHour() {
        return this.time.getHour();
    }
}
