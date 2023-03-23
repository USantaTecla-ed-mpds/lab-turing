package connect4.views.menu;

import connect4.models.Player;
import connect4.models.RandomPlayer;
import connect4.models.Turn;

public class CreateRandomPlayerOption extends ConfigTurnOption {

    public CreateRandomPlayerOption(Turn turn) {
        super("Random machine", turn);
    }

    @Override
    public void interact() {
        Player activePlayer = new RandomPlayer(this.turn.getBoard());
        this.turn.addPlayer(activePlayer);
    }
}
