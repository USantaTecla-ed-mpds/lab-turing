package main.es.labturing.connect4.views.menu;

import main.es.labturing.connect4.models.MinMaxPlayer;
import main.es.labturing.connect4.models.Turn;
import main.es.labturing.connect4.views.MessageManager;

public class CreateAIPlayerOption extends ConfigTurnOption {

    public CreateAIPlayerOption(Turn turn) {
        super(MessageManager.getInstance().getMessage("AI"), turn);
    }

    @Override
    public void interact() {
        this.turn.addPlayer(new MinMaxPlayer(this.turn.getBoard()));
    }

}
