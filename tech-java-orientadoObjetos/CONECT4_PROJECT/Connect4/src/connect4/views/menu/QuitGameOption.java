package connect4.views.menu;

import java.io.IOException;

import connect4.Connect4;
import connect4.utils.MessageManager;
import connect4.utils.exceptions.MessageNotFoundException;

public class QuitGameOption extends Connect4Option {

    public QuitGameOption(Connect4 connect4) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("EXIT"), connect4);
    }

    @Override
    public void interact() throws MessageNotFoundException, ClassNotFoundException, IOException {
        this.connect4.checkExit();
    }

}
