package main.es.labturing.connect4;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.ResumeController;
import main.es.labturing.connect4.models.Game;
import main.es.labturing.connect4.views.View;
import main.es.labturing.connect4.views.console.GameView;

public abstract class Connect4 {

    protected StartController startController;
    protected PlayController playController;
    protected ResumeController resumeController;
    protected UndoRedoController undoRedoController;
    protected Game game;
    protected View view;

    public Connect4() {
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
        this.undoRedoController = new UndoRedoController(this.game);
        this.view = this.createView();

    }

    protected abstract View createView();

    protected void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }

}
