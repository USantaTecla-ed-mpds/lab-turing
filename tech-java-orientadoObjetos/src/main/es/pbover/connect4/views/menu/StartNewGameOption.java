package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.Connect4;
import main.es.pbover.connect4.views.MessageManager;

public class StartNewGameOption extends Connect4Option {

    public StartNewGameOption(Connect4 connect4) {
        super(MessageManager.getInstance().getMessage("START"), connect4);
    }

    @Override
    public void interact() {
        this.connect4.playGames();
    }

}
