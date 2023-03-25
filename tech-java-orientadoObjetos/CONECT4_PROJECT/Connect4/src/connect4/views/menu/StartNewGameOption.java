package connect4.views.menu;

import java.io.IOException;

import connect4.Connect4;
import connect4.utils.exceptions.MessageNotFoundException;

public class StartNewGameOption extends Connect4Option {

    public StartNewGameOption(Connect4 connect4) {
        super("Start new game", connect4);
    }

    @Override
    public void interact() throws MessageNotFoundException, ClassNotFoundException, IOException {
        new ConfigTurnMenu(this.connect4.getTurn()).interact();
    }

}
