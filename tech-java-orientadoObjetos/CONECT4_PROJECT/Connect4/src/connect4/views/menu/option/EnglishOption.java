package connect4.views.menu.option;

import java.io.FileNotFoundException;
import java.io.IOException;

import connect4.Connect4;
import connect4.utils.Language;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.MessageManager;
import connect4.views.menu.Connect4Menu;

public class EnglishOption extends Connect4Option {

    public EnglishOption(Connect4 connect4) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("ENGLISH"), connect4);
    }

    public void interact() throws FileNotFoundException, IOException, MessageNotFoundException, ClassNotFoundException {
        MessageManager.getInstance().setLanguage(Language.ENGLISH);
        new Connect4Menu(MessageManager.getInstance().getMessage("GAME_TITLE"),this.connect4).interact();
    }
}
