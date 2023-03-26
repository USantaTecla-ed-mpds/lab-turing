package connect4.views.menu;

import connect4.models.MinMaxPlayer;
import connect4.models.Player;
import connect4.models.Turn;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.MessageManager;

public class CreateIAPlayerOption extends ConfigTurnOption {

    public CreateIAPlayerOption(Turn turn) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("AI"), turn);
    }

    @Override
    public void interact() {
        Player activePlayer = new MinMaxPlayer(this.turn.getBoard());
        this.turn.addPlayer(activePlayer);
    }

}
