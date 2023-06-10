package main.es.labturing.plaguesStats.src.main.cat.plagues;

public class DateFilter implements Responsable {

    private Responsable next;

    public DateFilter(Responsable responsable) {
        this.next = responsable;
    }

    @Override
    public CalendarEvent filter(FilterParameters filterParameters, CalendarEvent calendarEvent) {
        if(calendarEvent.getDateStart() != null){
            if (calendarEvent.getDateStart().getYear() == filterParameters.getYear()) {
                return this.next.filter(filterParameters, calendarEvent);
            }
        }
        return null;
    }
}
