package main.es.labturing.plaguesStats.src.main.cat.plagues;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {

    private Responsable collector;
    private Responsable addAsterisc;
    private Responsable searchString;
    private Responsable toLowerCase;
    private Responsable dateFilter;

    public FilterChain(){
        this.collector = new Collector();
        this.addAsterisc = new AddAsterisc(collector);
        this.searchString = new SearchString(addAsterisc);
        this.toLowerCase = new ToLowerCase(searchString);
        this.dateFilter = new DateFilter(toLowerCase);
    }

    public List<CalendarEvent> filter(FilterParameters filterParameters, List<CalendarEvent> calendarEvents){
        List<CalendarEvent> modified = new ArrayList<CalendarEvent>();
        for (CalendarEvent calendarEvent : calendarEvents) {
            if(this.dateFilter.filter(filterParameters, calendarEvent) != null){
                modified.add(this.dateFilter.filter(filterParameters, calendarEvent));
            }
        }
        return modified;
    }
    
}
