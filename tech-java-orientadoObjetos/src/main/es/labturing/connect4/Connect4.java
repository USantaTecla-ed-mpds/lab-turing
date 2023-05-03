package main.es.labturing.connect4;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.ResumeController;
import main.es.labturing.connect4.models.Game;
import main.es.labturing.connect4.views.console.GameView;
import main.es.labturing.utils.framework.GameApp;

public abstract class Connect4 extends GameApp<Game, GameView> {

    protected StartController startController;
    protected PlayController playController;
    protected ResumeController resumeController;
    protected UndoRedoController undoRedoController;

    public Connect4() {
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
        this.undoRedoController = new UndoRedoController(this.game);
        this.gameView = this.createView();

    }

    protected abstract GameView createView();

}
