package main.es.labturing.plaguesStats.src.main.cat.plagues;

public class ContainsWord implements Responsable {

    private Responsable next;

    public ContainsWord(Responsable responsable) {
        this.next = responsable;
    }

    @Override
    public CalendarEvent filter(FilterParameters filterParameters, CalendarEvent calendarEvent) {
        String[] separatedWords = calendarEvent.getSummary().split(" ");
        for (int i = 0; i < separatedWords.length; i++) {
            if (separatedWords[i].equals(filterParameters.getSearchWord())) {
                return this.next.filter(filterParameters, calendarEvent);
            }
        }
        return null;
    }
}
