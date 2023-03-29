package connect4.views.menu.option;

import java.io.IOException;

import connect4.Connect4;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.MessageManager;

public class StartNewGameOption extends Connect4Option {

    public StartNewGameOption(Connect4 connect4) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("NEW_GAME"), connect4);
    }

    @Override
    public void interact() throws MessageNotFoundException, ClassNotFoundException, IOException {
        this.connect4.play(true);
    }

}
