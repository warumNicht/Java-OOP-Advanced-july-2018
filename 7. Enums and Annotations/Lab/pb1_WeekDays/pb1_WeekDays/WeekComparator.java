package pb1_WeekDays;

import java.util.Comparator;

public class WeekComparator implements Comparator<WeeklyEntry> {

    @Override
    public int compare(WeeklyEntry o1, WeeklyEntry o2) {
        return o1.getWeekday().compareTo(o2.getWeekday());
    }
}
