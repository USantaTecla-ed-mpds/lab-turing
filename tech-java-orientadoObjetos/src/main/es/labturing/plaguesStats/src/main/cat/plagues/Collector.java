package main.es.labturing.plaguesStats.src.main.cat.plagues;

import java.util.ArrayList;
import java.util.List;

public class Collector implements Resposable{

    @Override
    public List<CalendarEvent> filter(int year, List<CalendarEvent> calendarEvents) {
        List<CalendarEvent> modified = new ArrayList<CalendarEvent>();

        for (CalendarEvent calendarEvent : calendarEvents) {
            modified.add(calendarEvent);
        }
        return modified;
    }
    
}
