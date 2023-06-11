package main.es.labturing.plaguesStats.src.main.cat.plagues;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {

    private EndFilterChain endFilterChain;
    private Responsable addAsterisc;
    private Responsable containsWord;
    private Responsable firstLetterUpperCase;
    private Responsable toLowerCase;
    private Responsable dateFilter;

    public FilterChain() {
        this.endFilterChain = new EndFilterChain();
        this.addAsterisc = new AddAsterisc(this.endFilterChain);
        this.firstLetterUpperCase = new FirstLetterUpperCase(this.addAsterisc);
        this.containsWord = new ContainsWord(this.firstLetterUpperCase);
        this.toLowerCase = new ToLowerCase(this.containsWord);
        this.dateFilter = new DateFilter(this.toLowerCase);
    }

    public List<CalendarEvent> filter(FilterParameters filterParameters, List<CalendarEvent> calendarEvents) {
        List<CalendarEvent> modified = new ArrayList<CalendarEvent>();
        for (CalendarEvent calendarEvent : calendarEvents) {
            if (this.dateFilter.filter(filterParameters, calendarEvent) != null) {
                modified.add(this.dateFilter.filter(filterParameters, calendarEvent));
            }
        }
        return modified;
    }

}
