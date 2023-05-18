package main.es.labturing.connect4;

import main.es.labturing.connect4.controllers.Logic;
import main.es.labturing.connect4.views.console.GameView;
import main.es.labturing.utils.framework.GameApp;

public abstract class Connect4 extends GameApp<Logic, GameView> {

    public Connect4() {
        this.logic = new Logic();
        this.gameView = this.createView();

    }

    protected abstract GameView createView();

}
