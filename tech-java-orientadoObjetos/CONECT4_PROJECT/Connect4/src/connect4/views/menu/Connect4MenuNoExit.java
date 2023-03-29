package connect4.views.menu;

import connect4.Connect4;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.utils.menu.Menu;

public abstract class Connect4MenuNoExit extends Menu {

    protected Connect4 connect4;

    public Connect4MenuNoExit(String title, Connect4 connect4) throws MessageNotFoundException {
        super(title);
        this.connect4 = connect4;
    }

}
