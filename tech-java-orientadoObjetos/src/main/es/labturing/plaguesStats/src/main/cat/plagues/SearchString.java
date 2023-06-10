package main.es.labturing.plaguesStats.src.main.cat.plagues;

public class SearchString implements Responsable {

    private Responsable next;

    public SearchString(Responsable responsable) {
        this.next = responsable;
    }

    @Override
    public CalendarEvent filter(FilterParameters filterParameters, CalendarEvent calendarEvent) {
        if(calendarEvent.getSummary().contains(filterParameters.getSearchWord())){
            return this.next.filter(filterParameters, calendarEvent);
        }
        return null;
    }
}
