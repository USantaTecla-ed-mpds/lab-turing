package main.es.labturing.plaguesStats.src.main.cat.plagues;

public interface Responsable {

    public CalendarEvent filter(FilterParameters filterParameters, CalendarEvent calendarEvent);
}
