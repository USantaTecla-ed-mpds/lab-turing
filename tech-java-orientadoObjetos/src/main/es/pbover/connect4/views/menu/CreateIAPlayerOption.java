package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.models.MinMaxPlayer;
import main.es.pbover.connect4.models.Player;
import main.es.pbover.connect4.models.Turn;
import main.es.pbover.connect4.views.MessageManager;

public class CreateIAPlayerOption extends ConfigTurnOption{

    public CreateIAPlayerOption(Turn turn) {
        super(MessageManager.getInstance().getMessage("AI"), turn);
    }

    @Override
    public void interact() {
        Player activePlayer = new MinMaxPlayer(this.turn.getBoard());
        this.turn.addPlayer(activePlayer);
    }

}
