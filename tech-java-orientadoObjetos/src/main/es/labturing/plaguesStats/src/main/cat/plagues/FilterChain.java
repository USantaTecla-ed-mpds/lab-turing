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
    private Responsable startFilterChain;

    public FilterChain() {
        this.endFilterChain = new EndFilterChain();
        this.addAsterisc = new AddAsterisc(this.endFilterChain);
        this.firstLetterUpperCase = new FirstLetterUpperCase(this.addAsterisc);
        this.containsWord = new ContainsWord(this.firstLetterUpperCase);
        this.toLowerCase = new ToLowerCase(this.containsWord);
        this.dateFilter = new DateFilter(this.toLowerCase);
        this.startFilterChain = new StartFilterChain(this.dateFilter);
    }

    public List<CalendarEvent> filter(FilterParameters filterParameters, List<CalendarEvent> calendarEvents) {
        List<CalendarEvent> modified = new ArrayList<CalendarEvent>();

        for (int i = 0; i < calendarEvents.size(); i++) {
            CalendarEvent calendarEvent = this.startFilterChain.filter(filterParameters, calendarEvents.get(i));
            if(calendarEvent != null){
                modified.add(calendarEvent);
            }
        }
        return modified;
    }

}
