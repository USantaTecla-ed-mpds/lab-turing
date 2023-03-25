package connect4.views.menu;

import java.io.IOException;

import connect4.Connect4;
import connect4.models.exceptions.MessageNotFoundException;
import connect4.utils.Console;
import connect4.utils.MessageManager;

public class LoadGameOption extends Connect4Option {

    public LoadGameOption(Connect4 connect4) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("LOAD_GAME"), connect4);
    }

    @Override
    public void interact() throws MessageNotFoundException, ClassNotFoundException, IOException {
        final String fileName = Console.getInstance()
                .readString(MessageManager.getInstance().getMessage("ENTER_FILE_NAME"));

        this.connect4.loadGame(fileName);
    }

}
