package main.es.labturing.plaguesStats.src.main.cat.plagues;

import java.util.List;

public class FilterChain {

    private Resposable collector;
    private Resposable addAsterisc;
    private Resposable toLowerCase;
    private Resposable dateFilter;

    public FilterChain(){
        this.collector = new Collector();
        this.addAsterisc = new AddAsterisc(collector);
        this.toLowerCase = new ToLowerCase(addAsterisc);
        this.dateFilter = new DateFilter(toLowerCase);
    }

    public List<CalendarEvent> filter(int year, List<CalendarEvent> calendarEvents){
        return this.dateFilter.filter(year, calendarEvents);
    }
    
}
