package main.es.pbover.connecta$.views.menu;

import main.es.pbover.utils.menu.Option;
import main.es.pbover.connecta$.Connect4;

public abstract class Connect4Option extends Option{

    protected Connect4 connect4;

    public Connect4Option(String title, Connect4 connect4) {
        super(title);
        this.connect4 = connect4;
    }
    
}
