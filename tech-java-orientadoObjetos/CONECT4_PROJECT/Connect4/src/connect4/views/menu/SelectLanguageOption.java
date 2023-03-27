package connect4.views.menu;

import java.io.IOException;

import connect4.Connect4;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.utils.menu.Option;
import connect4.views.MessageManager;


public class SelectLanguageOption extends Option {

    protected MessageManager messageManager;
    protected Connect4 connect4;

    public SelectLanguageOption(Connect4 connect4) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("SELECT_LANGUAGE"));
        this.messageManager = MessageManager.getInstance();
        this.connect4  = connect4;
    }

    @Override
    public void interact() throws MessageNotFoundException, ClassNotFoundException, IOException {
        new SelectLanguageMenu(this.connect4).interact();
    }

}