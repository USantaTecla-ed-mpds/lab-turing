package main.es.labturing.plaguesStats.src.main.cat.plagues;

public class FilterChain {

    private Resposable collector;
    private Resposable addAsterisc;
    private Resposable toLowerCase;

    public FilterChain(){
        this.collector = new Collector();
        this.addAsterisc = new AddAsterisc(collector);
        this.toLowerCase = new ToLowerCase(addAsterisc);
    }

    public String filter(String text){
        return this.toLowerCase.filter(text);
    }
    
}
