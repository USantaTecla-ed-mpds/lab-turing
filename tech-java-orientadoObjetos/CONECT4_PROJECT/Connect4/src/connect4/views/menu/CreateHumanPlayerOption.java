package connect4.views.menu;

import connect4.models.Player;
import connect4.models.Turn;
import connect4.models.creator.HumanPlayerCreator;
import connect4.models.creator.PlayerCreator;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.MessageManager;

public class CreateHumanPlayerOption extends ConfigTurnOption {

    public CreateHumanPlayerOption(Turn turn) throws MessageNotFoundException {
        super(MessageManager.getInstance().getMessage("HUMAN"), turn);
    }

    @Override
    public void interact() {
        PlayerCreator creator = new HumanPlayerCreator();
        Player activePlayer = creator.createPlayer(this.turn.getBoard());
        this.turn.addPlayer(activePlayer);
    }
}
