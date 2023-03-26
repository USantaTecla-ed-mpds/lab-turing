package connect4.views.menu;

import connect4.models.HumanPlayer;
import connect4.models.Player;
import connect4.models.Turn;
import connect4.utils.MessageManager;
import connect4.utils.exceptions.MessageNotFoundException;

public class CreateHumanPlayerOption extends ConfigTurnOption {

    public CreateHumanPlayerOption(Turn turn) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("HUMAN"), turn);
    }

    @Override
    public void interact() {
        Player activePlayer = new HumanPlayer(this.turn.getBoard());
        this.turn.addPlayer(activePlayer);
    }
}
