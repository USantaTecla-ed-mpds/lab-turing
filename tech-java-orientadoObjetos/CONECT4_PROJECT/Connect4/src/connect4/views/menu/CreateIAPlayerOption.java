package connect4.views.menu;

import connect4.models.MinMaxPlayer;
import connect4.models.Player;
import connect4.models.Turn;

public class CreateIAPlayerOption extends ConfigTurnOption {

    public CreateIAPlayerOption(Turn turn) {
        super("IA machine", turn);
    }

    @Override
    public void interact() {
        Player activePlayer = new MinMaxPlayer(this.turn.getBoard());
        this.turn.addPlayer(activePlayer);
    }

}
