package main.es.labturing.plaguesStats.src.main.cat.plagues;
public class Collector implements Responsable{

    @Override
    public CalendarEvent filter(FilterParameters filterParameters, CalendarEvent calendarEvent) {
        return calendarEvent;
    }
}
