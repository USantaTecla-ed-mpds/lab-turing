package main.es.pbover.connecta$.views;

import main.es.pbover.connecta$.models.Turn;
import main.es.pbover.connecta$.models.HumanPlayer;
import main.es.pbover.connecta$.models.Player;

public class CreateHumanPlayerOption extends TurnOption{

    public CreateHumanPlayerOption(Turn turn) {
        super("Human", turn);
    }

    @Override
    public void interact() {
        Player activePlayer = new HumanPlayer(this.turn.getNextColor(), this.turn.getBoard());
        //Player activePlayer = PlayerFactory.HumanPlayer.buildPlayer(this.turn.getNextColor(), this.turn.getBoard());
        this.turn.setPlayers(activePlayer);
    }
}
