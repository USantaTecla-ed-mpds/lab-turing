package connect4.views.menu;

import connect4.Connect4;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.MessageManager;
import connect4.views.menu.option.EnglishOption;
import connect4.views.menu.option.SpanishOption;

public class LanguageMenu extends Connect4MenuNoExit {

    public LanguageMenu(Connect4 connect4) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("SELECT_LANGUAGE"), connect4);
    }

    @Override
    protected void addOptions() throws MessageNotFoundException {
        this.add(new SpanishOption(connect4));
        this.add(new EnglishOption(connect4));
    }

}
