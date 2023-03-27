package connect4.views.menu;

import java.io.IOException;

import connect4.models.GamesManager;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.utils.menu.Option;

public class SaveGameOption extends Option {

    public SaveGameOption(String title) throws MessageNotFoundException {
        super(title);
    }

    @Override
    public void interact() throws MessageNotFoundException, IOException {
        GamesManager.getInstance().showSaveGameDialog();
    }
}
