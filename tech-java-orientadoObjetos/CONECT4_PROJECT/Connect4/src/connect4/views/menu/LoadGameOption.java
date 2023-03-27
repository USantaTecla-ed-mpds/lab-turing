package connect4.views.menu;

import java.io.IOException;

import connect4.Connect4;
import connect4.models.GamesManager;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.MessageManager;

public class LoadGameOption extends Connect4Option {

    public LoadGameOption(Connect4 connect4) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("LOAD_GAME"), connect4);
    }

    @Override
    public void interact() throws MessageNotFoundException, ClassNotFoundException, IOException {

        GamesManager.getInstance().showLoadGameDialog();
        this.connect4.play(false);

    }

}
