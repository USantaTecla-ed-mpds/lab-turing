package main.es.pbover.connecta$.views.menu;

import main.es.pbover.connecta$.Connect4;

public class StartNewGameOption extends Connect4Option{

    public StartNewGameOption(Connect4 connect4){
        super("Start new game", connect4);
    }

    @Override
    public void interact() {
        new ConfigPlayerMenu(this.connect4.getTurn()).interact();
    }
    
}
