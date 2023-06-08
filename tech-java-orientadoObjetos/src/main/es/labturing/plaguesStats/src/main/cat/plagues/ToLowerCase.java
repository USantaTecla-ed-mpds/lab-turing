package main.es.labturing.plaguesStats.src.main.cat.plagues;

public class ToLowerCase implements Resposable{

    private Resposable next;

    public ToLowerCase(Resposable next){
        this.next = next;
    }

    @Override
    public String filter(String text) {
        String modified = text.toLowerCase();
        return next.filter(modified);
    }
    
}
