package main.es.labturing.plaguesStats.src.main.cat.plagues;

import java.util.List;

public interface Resposable {

    public List<CalendarEvent> filter(int year, List<CalendarEvent> calendarEvents);
}
