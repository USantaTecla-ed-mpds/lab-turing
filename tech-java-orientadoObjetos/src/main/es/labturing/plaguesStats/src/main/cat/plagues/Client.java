package main.es.labturing.plaguesStats.src.main.cat.plagues;

import java.util.List;

public class Client {

    private List<CalendarEvent> CalendarEvents;

    public static void main(String[] args) {
        new Client().run();
    }

    public void run(){
        CalendarEventDAO calendarEventDAO = new CalendarEventDAO();
        this.CalendarEvents = calendarEventDAO.read(); 
        FilterChain filterChain = new FilterChain();
        List<CalendarEvent> CalendarEventsModified = filterChain.filter(2014, this.CalendarEvents);

        for (CalendarEvent calendarEvent : CalendarEventsModified) {
            System.out.println(calendarEvent.getDateStart() + " : " + calendarEvent.getSummary());  
        }  
    }
    
}
