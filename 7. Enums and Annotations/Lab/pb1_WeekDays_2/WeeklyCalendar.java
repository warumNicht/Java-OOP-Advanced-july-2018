package pb1_WeekDays_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeeklyCalendar {
    private List<WeeklyEntry> entries;

    public WeeklyCalendar() {
        this.entries=new ArrayList<>();
    }

    public void addEntry(String weekday,String notes,String season){
        this.entries.add(new WeeklyEntry(weekday,notes,season));
    }
    public Iterable<WeeklyEntry> getWeeklySchedule(){

        Collections.sort(this.entries,WeeklyEntry.BY_WEEKDAY);
        return this.entries;
    }
}
