package connect4.views.menu.option;

import java.io.IOException;

import connect4.Connect4;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.MessageManager;
import connect4.views.menu.LanguageMenu;

public class LanguageOption extends Connect4Option {

    public LanguageOption(Connect4 connect4) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("SELECT_LANGUAGE"), connect4);
    }

    @Override
    public void interact() throws MessageNotFoundException, ClassNotFoundException, IOException {
        new LanguageMenu(this.connect4).interact();
    }

}