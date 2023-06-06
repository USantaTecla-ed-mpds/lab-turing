package main.cat.plagues;

import java.util.List;

public class Client {

    private List<CalendarEvent> CalendarEventList;

    public static void main(String[] args) {
        new Client().run();
    }

    public void run(){
        CalendarEventDAO calendarEventDAO = new CalendarEventDAO();
        this.CalendarEventList = calendarEventDAO.read(); 
        for (CalendarEvent calendar : this.CalendarEventList) {
            System.out.println(calendar.getSummary());
        }
    }
    
}
