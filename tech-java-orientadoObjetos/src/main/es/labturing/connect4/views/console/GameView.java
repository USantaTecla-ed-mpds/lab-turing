package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.ResumeController;
import main.es.labturing.connect4.views.View;
import main.es.labturing.connect4.views.console.menu.LanguageMenu;
import main.es.labturing.utils.views.YesNoDialog;

public class GameView extends View{

    private BoardView boardView;
    private TurnView turnView;

    public GameView(StartController startController, PlayController playController, ResumeController resumeController, UndoRedoController undoRedoController) {
        super(startController, playController, resumeController, undoRedoController);  
        this.boardView = new BoardView(startController);
        this.turnView = new TurnView(startController, playController, undoRedoController);
    }

    @Override
    public void start() {
        new LanguageMenu("SELECT LANGUAGE:").interact();
        this.turnView.configTurn();
        MessageManager.getInstance().writeln("GAME_TITLE");
        this.boardView.writeln();
    }

    @Override
    public void play() {
        do {
            turnView.play();
            boardView.writeln();
        } while (!this.playController.isGameFinished());
        turnView.writeResult();
    }

    @Override
    public boolean resume() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(MessageManager.getInstance().getMessage("RESUME"));
        if (yesNoDialog.isAffirmative()) {
            this.resumeController.reset();
        }
        return yesNoDialog.isAffirmative();

    }

}
