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
        FilterParameters filterParameters = new FilterParameters(2023, "edu");
        List<CalendarEvent> CalendarEventsModified = filterChain.filter(filterParameters, this.CalendarEvents);

        // int counter = 0;
        // for (CalendarEvent calendarEvent : CalendarEventsModified) {
        //     counter++;
        //     System.out.println(counter + ". " + calendarEvent.getDateStart() + " : " + calendarEvent.getSummary());  
        // } 
        
        System.out.println("Total events for year " 
                        + filterParameters.getYear() 
                        + " and word \"" 
                        + filterParameters.getSearchWord()
                        + "\" : "
                        + CalendarEventsModified.size()
                        );
    }
    
}
