package main.es.labturing.plaguesStats.src.main.cat.plagues;

public class AddAsterisc implements Resposable{

    private Resposable next;

    public AddAsterisc(Resposable next){
        this.next = next;
    }

    @Override
    public String filter(String text) {
        String modified = "* " + text;
        return next.filter(modified);
    }
    
}
