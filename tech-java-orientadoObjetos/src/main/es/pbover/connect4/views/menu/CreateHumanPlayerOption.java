package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.models.HumanPlayer;
import main.es.pbover.connect4.models.Turn;
import main.es.pbover.connect4.views.MessageManager;

public class CreateHumanPlayerOption extends ConfigTurnOption{

    public CreateHumanPlayerOption(Turn turn) {
        super(MessageManager.getInstance().getMessage("HUMAN"), turn);
    }

    @Override
    public void interact() {
        this.turn.addPlayer(new HumanPlayer(this.turn.getBoard()));
    }
}
