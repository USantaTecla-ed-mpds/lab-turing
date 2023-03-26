package main.es.pbover.connect4.views.menu;

import main.es.pbover.utils.menu.Menu;

public class SelectLanguageMenu extends Menu{


    public SelectLanguageMenu(String title) {
        super(title);
    }

    @Override
    protected void addOptions(){
        this.add(new SpanishOption());
        this.add(new EnglishOption());

    }
    
}
