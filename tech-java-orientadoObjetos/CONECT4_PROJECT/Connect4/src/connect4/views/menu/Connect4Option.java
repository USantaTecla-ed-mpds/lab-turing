package connect4.views.menu;

import connect4.Connect4;
import connect4.utils.menu.Option;

public abstract class Connect4Option extends Option {

    protected Connect4 connect4;

    public Connect4Option(String title, Connect4 connect4) {
        super(title);
        this.connect4 = connect4;
    }

}
