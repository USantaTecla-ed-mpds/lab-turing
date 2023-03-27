package connect4.views.menu;

import connect4.Connect4;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.utils.menu.Menu;
import connect4.views.MessageManager;


public class SelectLanguageMenu extends Menu{


    private Connect4 connect4;

    public SelectLanguageMenu(Connect4 connect4) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("SELECT_LANGUAGE"));
        this.connect4 = connect4;
    }

    @Override
    protected void addOptions() throws MessageNotFoundException{
        this.add(new SpanishOption(connect4));
        this.add(new EnglishOption(connect4));
    }
    
}
