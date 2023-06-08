package main.es.labturing.connect4;

import main.es.labturing.connect4.controllers.AcceptorController;
import main.es.labturing.connect4.controllers.Logic;
import main.es.labturing.connect4.daos.SessionDAO;
import main.es.labturing.connect4.views.GameView;

public abstract class Connect4 {

    protected Logic logic;
    protected GameView gameView;

    public Connect4() {
        this.logic = new Logic(new SessionDAO());
        this.gameView = this.createView();

    }

    protected void interact() {
        AcceptorController acceptorController;
        do {
            acceptorController = this.logic.getController();
            if (acceptorController != null)
                acceptorController.accept(this.gameView);
        } while (acceptorController != null);
    }

    protected abstract GameView createView();

}
