package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.connect4.views.console.TurnView;
import main.es.labturing.utils.views.menu.Option;

public class StartNewGameOption extends Option {

    private TurnView turnView;
    private StartController startController;

    public StartNewGameOption(TurnView turnView, StartController startController) {
        super(MessageManager.getInstance().getMessage("START"));
        this.turnView = turnView;
        this.startController = startController;
    }

    @Override
    public void interact() {
        this.turnView.configTurn(this.startController);
    }

}
