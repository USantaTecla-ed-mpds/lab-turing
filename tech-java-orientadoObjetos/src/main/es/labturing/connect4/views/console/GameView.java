package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.ResumeController;
import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.types.StageValue;
import main.es.labturing.connect4.views.console.menu.GameMenu;
import main.es.labturing.connect4.views.console.menu.LanguageMenu;
import main.es.labturing.connect4.controllers.ControllersVisitor;
import main.es.labturing.utils.views.YesNoDialog;

public class GameView extends ControllersVisitor implements main.es.labturing.connect4.views.GameView {

    private BoardView boardView;
    private TurnView turnView;

    public GameView() {
        this.boardView = new BoardView();
        this.turnView = new TurnView();
    }

    private void start(StartController startController) {
        new LanguageMenu("SELECT LANGUAGE:").interact();
        new GameMenu(this.turnView, startController).interact();
        MessageManager.getInstance().writeln("GAME_TITLE");
        this.boardView.writeln(startController);
    }

    private void play(PlayController playController) {
        do {
            turnView.play(playController);
            if (playController.getStageValue() == StageValue.IN_GAME) {
                boardView.writeln(playController);
            }
        } while (playController.getStageValue() == StageValue.IN_GAME && !playController.isGameFinished());
        if (playController.getStageValue() == StageValue.IN_GAME) {
            turnView.writeResult(playController);
        }
    }

    private boolean resume(ResumeController resumeController) {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(MessageManager.getInstance().getMessage("RESUME"));
        if (yesNoDialog.isAffirmative()) {
            resumeController.reset();
        }
        return yesNoDialog.isAffirmative();
    }
    @Override
    public void visit(StartController startController) {
        this.start(startController);
        startController.nextStage();
    }
    @Override
    public void visit(PlayController playController) {
        this.play(playController);
        playController.nextStage();
    }
    @Override
    public boolean visit(ResumeController resumeController) {
        this.resume(resumeController);
        resumeController.nextStage();
        return true;
    }

}
