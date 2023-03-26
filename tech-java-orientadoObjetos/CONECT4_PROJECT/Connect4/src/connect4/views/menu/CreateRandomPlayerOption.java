package connect4.views.menu;

import connect4.models.Player;
import connect4.models.RandomPlayer;
import connect4.models.Turn;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.MessageManager;

public class CreateRandomPlayerOption extends ConfigTurnOption {

    public CreateRandomPlayerOption(Turn turn) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("RANDOM"), turn);
    }

    @Override
    public void interact() {
        Player activePlayer = new RandomPlayer(this.turn.getBoard());
        this.turn.addPlayer(activePlayer);
    }
}
