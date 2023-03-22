package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.models.MinMaxPlayer;
import main.es.pbover.connect4.models.Player;
import main.es.pbover.connect4.models.Turn;

public class CreateIAPlayerOption extends ConfigTurnOption{

    public CreateIAPlayerOption(Turn turn) {
        super("IA machine", turn);
    }

    @Override
    public void interact() {
        Player activePlayer = new MinMaxPlayer(this.turn.getBoard());
        this.turn.addPlayer(activePlayer);
    }

}
