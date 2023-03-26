package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.models.RandomPlayer;
import main.es.pbover.connect4.models.Turn;
import main.es.pbover.connect4.views.MessageManager;

public class CreateRandomPlayerOption extends ConfigTurnOption {

    public CreateRandomPlayerOption(Turn turn) {
        super(MessageManager.getInstance().getMessage("RANDOM"), turn);
    }

    @Override
    public void interact() {
        this.turn.addPlayer(new RandomPlayer(this.turn.getBoard()));
    }
}
