package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.ResumeController;
import main.es.labturing.connect4.views.console.menu.LanguageMenu;
import main.es.labturing.utils.views.YesNoDialog;

public class GameView implements main.es.labturing.utils.framework.GameView {

    private PlayController playController;
    private ResumeController resumeController;
    private BoardView boardView;
    private TurnView turnView;


    public GameView(StartController startController, PlayController playController,
    ResumeController resumeController, UndoRedoController undoRedoController) {
        this.playController = playController;
        this.resumeController = resumeController;
        this.boardView = new BoardView(startController);
        this.turnView = new TurnView(startController, this.playController, undoRedoController);
    }

    public void start() {
        new LanguageMenu("SELECT LANGUAGE:").interact();
        this.turnView.configTurn();
        MessageManager.getInstance().writeln("GAME_TITLE");
        this.boardView.writeln();
    }

    public void play() {
        do {
            turnView.play();
            boardView.writeln();
        } while (!this.playController.isGameFinished());
        turnView.writeResult();
    }

    public boolean resume() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(MessageManager.getInstance().getMessage("RESUME"));
        if (yesNoDialog.isAffirmative()) {
            this.resumeController.reset();
        }
        return yesNoDialog.isAffirmative();

    }

}
