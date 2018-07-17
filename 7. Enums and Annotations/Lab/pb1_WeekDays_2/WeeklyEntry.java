package pb1_WeekDays_2;

import java.util.Comparator;

public class WeeklyEntry {
    private Weekday weekday;
    private Season season;
    private String notes;

    public final static Comparator<WeeklyEntry> BY_WEEKDAY= getCompByDay();

    private static Comparator<WeeklyEntry> getCompByDay() {
        return (e1,e2)->e1.weekday.compareTo(e2.weekday);
    }

    public WeeklyEntry(String weekday, String notes,String season) {

        this.notes = notes;
        this.season=Enum.valueOf(Season.class,season.toUpperCase());
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
    }

    public Weekday getWeekday() {
        return weekday;
    }

    @Override
    public String toString() {
        return this.weekday + " - " + this.notes;
    }
}
