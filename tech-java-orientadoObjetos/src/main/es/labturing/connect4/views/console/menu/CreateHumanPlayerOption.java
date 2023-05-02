package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.types.PlayerType;
import main.es.labturing.connect4.views.console.MessageManager;

public class CreateHumanPlayerOption extends ConfigTurnOption {

    public CreateHumanPlayerOption(StartController startController) {
        super(MessageManager.getInstance().getMessage("HUMAN"), startController);
    }

    @Override
    public void interact() {
        this.startController.addPlayer(PlayerType.HUMAN);
    }

}
