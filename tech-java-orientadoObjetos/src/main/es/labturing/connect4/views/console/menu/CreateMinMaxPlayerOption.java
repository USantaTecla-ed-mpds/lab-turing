package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.views.console.MessageManager;

public class CreateMinMaxPlayerOption extends ConfigTurnOption {

    public CreateMinMaxPlayerOption(StartController startController) {
        super(MessageManager.getInstance().getMessage("AI"), startController);
    }

    @Override
    public void interact() {
        this.startController.addMinMaxPlayer();
    }

}
