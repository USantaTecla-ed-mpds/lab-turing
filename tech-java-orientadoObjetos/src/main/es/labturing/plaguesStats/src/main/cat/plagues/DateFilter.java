package main.es.labturing.plaguesStats.src.main.cat.plagues;

import java.util.ArrayList;
import java.util.List;

public class DateFilter implements Resposable{

    private Resposable next;

    public DateFilter(Resposable responsable){
        this.next = responsable;
    }

    @Override
    public List<CalendarEvent> filter(int year, List<CalendarEvent> calendarEvents) {
        List<CalendarEvent> modified = new ArrayList<CalendarEvent>();

        for (CalendarEvent calendarEvent : calendarEvents) {
            if(calendarEvent.getDateStart().getYear() == year){
                modified.add(calendarEvent);
            }
        }
        return next.filter(year, modified); 
    }
}
