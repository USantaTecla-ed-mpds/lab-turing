package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.ResumeController;
import main.es.labturing.connect4.controllers.StartController;

public class GameView
        extends main.es.labturing.utils.framework.GameView<StartController, PlayController, ResumeController> {

    private BoardView boardView;
    private TurnView turnView;

    public GameView(StartController startController, PlayController playController, ResumeController resumeController) {
        super(startController, playController, resumeController);
        this.boardView = new BoardView(this.startController.getGame().getBoard());
        this.turnView = new TurnView(this.startController.getGame().getTurn());
    }

    public void start() {
        this.startController.interact(this.boardView);
    }

    public void play() {
        this.playController.interact(this.turnView, this.boardView);
    }

    public boolean resume() {
        return this.resumeController.interact(this.turnView);
    }

}
