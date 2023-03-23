package connect4.views.menu;

import connect4.Connect4;

public class StartNewGameOption extends Connect4Option {

    public StartNewGameOption(Connect4 connect4) {
        super("Start new game", connect4);
    }

    @Override
    public void interact() {
        new ConfigTurnMenu(this.connect4.getTurn()).interact();
    }

}
