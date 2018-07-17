package pb1_WeekDays;

public class WeeklyEntry {
    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
        this.notes = notes;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    @Override
    public String toString() {
        return this.weekday + " - " + this.notes;
    }
}
