package pb1_WeekDays_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(Season.AUTUMN);

        WeeklyCalendar wc=new WeeklyCalendar();

        wc.addEntry("Friday","sleep","Spring");
        wc.addEntry("Monday","sport","Summer");

                                                                                                                                                                                                                                                                            Iterable<WeeklyEntry> shedule=wc.getWeeklySchedule();

        for (WeeklyEntry weeklyEntry : shedule) {
            System.out.println(weeklyEntry);
        }

    }
}
