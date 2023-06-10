package main.es.labturing.plaguesStats.src.main.cat.plagues;

public class AddAsterisc implements Responsable {

    private Responsable next;

    public AddAsterisc(Responsable responsable) {
        this.next = responsable;
    }

    @Override
    public CalendarEvent filter(FilterParameters filterParameters, CalendarEvent calendarEvent) {
        if(calendarEvent.getSummary() != null){
            String modified = "* " + calendarEvent.getSummary();
            calendarEvent.setSummary(modified);
            return this.next.filter(filterParameters, calendarEvent);
        }
        return null;
    }

}
