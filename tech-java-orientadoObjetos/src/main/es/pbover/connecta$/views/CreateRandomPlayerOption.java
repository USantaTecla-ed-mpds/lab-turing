package main.es.pbover.connecta$.views;

import main.es.pbover.connecta$.models.Turn;
import main.es.pbover.connecta$.models.RandomPlayer;
import main.es.pbover.connecta$.models.Player;

public class CreateRandomPlayerOption extends TurnOption{

    public CreateRandomPlayerOption(Turn turn) {
        super("Random machine", turn);
    }

    @Override
    public void interact() {
        Player activePlayer = new RandomPlayer(this.turn.getNextColor(), this.turn.getBoard());
        //Player activePlayer = PlayerFactory.RandomPlayer.buildPlayer(this.turn.getNextColor(), this.turn.getBoard());
        this.turn.setPlayers(activePlayer);    }

}
