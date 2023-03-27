package connect4.views.menu;

import java.io.FileNotFoundException;
import java.io.IOException;

import connect4.Connect4;
import connect4.utils.Language;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.utils.menu.Option;
import connect4.views.MessageManager;

public class EnglishOption extends Option {

    private Connect4 connect4;

    public EnglishOption(Connect4 connect4) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("ENGLISH"));
        this.connect4 = connect4;
    }

    public void interact() throws FileNotFoundException, IOException, MessageNotFoundException, ClassNotFoundException {
        MessageManager.getInstance().setLanguage(Language.ENGLISH);
        new Connect4Menu(this.connect4).interact();
    }
}
