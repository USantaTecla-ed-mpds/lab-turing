package main.es.labturing.plaguesStats.src.main.cat.plagues;

public class StartFilterChain implements Responsable{

    private Responsable next;

    public StartFilterChain(Responsable responsable){
        this.next = responsable;
    }

    @Override
    public CalendarEvent filter(FilterParameters filterParameters, CalendarEvent calendarEvent) {
        return this.next.filter(filterParameters, calendarEvent);
    }
    
}
