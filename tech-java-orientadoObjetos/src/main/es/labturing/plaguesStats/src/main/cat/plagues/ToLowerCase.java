package main.es.labturing.plaguesStats.src.main.cat.plagues;

import java.util.ArrayList;
import java.util.List;

public class ToLowerCase implements Resposable{

    private Resposable next;

    public ToLowerCase(Resposable resposable){
        this.next = resposable;
    }

    @Override
    public List<CalendarEvent> filter(int year, List<CalendarEvent> calendarEvents) {
        List<CalendarEvent> modified = new ArrayList<CalendarEvent>();

        for (int i = 0; i < calendarEvents.size(); i++) {
            modified.add(calendarEvents.get(i));
            modified.get(i).setSummary(calendarEvents.get(i).getSummary().toLowerCase());
        }
        return next.filter(year, modified);
    }
    
}
