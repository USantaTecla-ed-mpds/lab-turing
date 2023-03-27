package main.es.pbover.connect4.views.menu;

import main.es.pbover.utils.menu.Menu;

public class LanguageMenu extends Menu{


    public LanguageMenu(String title) {
        super(title);
    }

    @Override
    protected void addOptions(){
        this.add(new SpanishOption());
        this.add(new EnglishOption());

    }
    
}
