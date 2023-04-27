package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.views.console.MessageManager;

public class CreateRandomPlayerOption extends ConfigTurnOption {

    public CreateRandomPlayerOption(StartController startController) {
        super(MessageManager.getInstance().getMessage("RANDOM"), startController);
    }

    @Override
    public void interact() {
        this.startController.addRandomPlayer();
    }
}
