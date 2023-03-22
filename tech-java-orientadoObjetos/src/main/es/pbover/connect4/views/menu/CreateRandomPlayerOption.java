package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.models.Player;
import main.es.pbover.connect4.models.RandomPlayer;
import main.es.pbover.connect4.models.Turn;

public class CreateRandomPlayerOption extends ConfigTurnOption{

    public CreateRandomPlayerOption(Turn turn) {
        super("Random machine", turn);
    }

    @Override
    public void interact() {
        Player activePlayer = new RandomPlayer(this.turn.getBoard());
        this.turn.addPlayer(activePlayer);    
    }
}
