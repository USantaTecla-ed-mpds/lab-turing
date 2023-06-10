package main.es.labturing.plaguesStats.src.main.cat.plagues;

public class ToLowerCase implements Responsable{

    private Responsable next;

    public ToLowerCase(Responsable responsable){
        this.next = responsable;
    }

    @Override
    public CalendarEvent filter(FilterParameters filterParameters, CalendarEvent calendarEvent) { 
        if(calendarEvent.getSummary() != null){
            calendarEvent.setSummary(calendarEvent.getSummary().toLowerCase());
            return this.next.filter(filterParameters, calendarEvent);
        }   
        return null;
    }
    
}
