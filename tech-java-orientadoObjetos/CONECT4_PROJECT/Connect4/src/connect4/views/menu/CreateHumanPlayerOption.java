package connect4.views.menu;

import connect4.models.HumanPlayer;
import connect4.models.Player;
import connect4.models.Turn;

public class CreateHumanPlayerOption extends ConfigTurnOption {

    public CreateHumanPlayerOption(Turn turn) {
        super("Human", turn);
    }

    @Override
    public void interact() {
        Player activePlayer = new HumanPlayer(this.turn.getBoard());
        this.turn.addPlayer(activePlayer);
    }
}
