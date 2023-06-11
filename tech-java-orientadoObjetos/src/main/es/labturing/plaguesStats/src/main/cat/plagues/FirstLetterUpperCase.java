package main.es.labturing.plaguesStats.src.main.cat.plagues;

public class FirstLetterUpperCase implements Responsable {

    Responsable next;

    public FirstLetterUpperCase(Responsable responsable) {
        this.next = responsable;
    }

    @Override
    public CalendarEvent filter(FilterParameters filterParameters, CalendarEvent calendarEvent) {
        if(calendarEvent.getSummary() != null){
            calendarEvent.setSummary(calendarEvent.getSummary().trim());
            String modified = calendarEvent.getSummary().substring(0, 1).toUpperCase()
                    + calendarEvent.getSummary().substring(1);
            calendarEvent.setSummary(modified);
            return this.next.filter(filterParameters, calendarEvent);
        }
        return null;
    }

}
