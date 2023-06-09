package main.es.labturing.plaguesStats.src.main.cat.plagues;

import java.util.ArrayList;
import java.util.List;

public class AddAsterisc implements Resposable{

    private Resposable next;

    public AddAsterisc(Resposable resposable){
        this.next = resposable;
    }

    @Override
    public List<CalendarEvent> filter(int year, List<CalendarEvent> calendarEvents) {
        List<CalendarEvent> modified = new ArrayList<CalendarEvent>();

        for (int i = 0; i < calendarEvents.size(); i++) {
            modified.add(calendarEvents.get(i));
            modified.get(i).setSummary("* " + calendarEvents.get(i).getSummary());
        }
        return next.filter(year, modified);
    }
    
}
