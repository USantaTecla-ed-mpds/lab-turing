package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.models.HumanPlayer;
import main.es.pbover.connect4.models.Player;
import main.es.pbover.connect4.models.Turn;

public class CreateHumanPlayerOption extends ConfigTurnOption{

    public CreateHumanPlayerOption(Turn turn) {
        super("Human", turn);
    }

    @Override
    public void interact() {
        Player activePlayer = new HumanPlayer(this.turn.getBoard());
        this.turn.addPlayer(activePlayer);
    }
}
