package main.es.pbover.connecta$.views;

import main.es.pbover.connecta$.models.Turn;
import main.es.pbover.connecta$.models.MinMaxPlayer;
import main.es.pbover.connecta$.models.Player;

public class CreateIAPlayerOption extends TurnOption{

    public CreateIAPlayerOption(Turn turn) {
        super("IA machine", turn);
    }

    @Override
    public void interact() {
        Player activePlayer = new MinMaxPlayer(this.turn.getNextColor(), this.turn.getBoard());
        //Player activePlayer = PlayerFactory.MinMaxPlayer.buildPlayer(this.turn.getNextColor(), this.turn.getBoard());
        this.turn.setPlayers(activePlayer);
    }

}
