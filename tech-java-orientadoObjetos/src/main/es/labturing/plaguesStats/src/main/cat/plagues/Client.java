package main.es.labturing.plaguesStats.src.main.cat.plagues;

import java.util.List;

public class Client {

    private List<CalendarEvent> CalendarEventList;

    public static void main(String[] args) {
        new Client().run();
    }

    public void run(){
        CalendarEventDAO calendarEventDAO = new CalendarEventDAO();
        this.CalendarEventList = calendarEventDAO.read(); 
        //Check
        for (CalendarEvent event : this.CalendarEventList) {
            System.out.println(event.getSummary());
            System.out.println(event.getStart());
        }
        //App
    }
    
}
