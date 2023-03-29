package connect4.views.menu.option;

import java.io.IOException;

import connect4.Connect4;
import connect4.utils.exceptions.MessageNotFoundException;

public class SaveGameOption extends Connect4Option {

    public SaveGameOption(String title, Connect4 connect4) throws MessageNotFoundException {
        super(title, connect4);
    }

    @Override
    public void interact() throws MessageNotFoundException, IOException, ClassNotFoundException {
        this.connect4.showSaveGameDialog();
    }
}
