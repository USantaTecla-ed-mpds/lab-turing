package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.ResumeController;
import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.views.console.menu.GameMenu;
import main.es.labturing.connect4.views.console.menu.LanguageMenu;
import main.es.labturing.utils.framework.ControllersVisitor;
import main.es.labturing.utils.views.YesNoDialog;

public class GameView implements ControllersVisitor {

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
        startController.nextStage();
    }

    private void play(PlayController playController) {
        do {
            turnView.play(playController);
            boardView.writeln(playController);
        } while (!playController.isGameFinished());
        turnView.writeResult(playController);
    }

    private boolean resume(ResumeController resumeController) {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(MessageManager.getInstance().getMessage("RESUME"));
        if (yesNoDialog.isAffirmative()) {
            resumeController.reset();//stage reset
        }
        return yesNoDialog.isAffirmative();
    }

    public void visit(StartController startController) {
        this.start(startController);
        startController.nextStage();
    }

	public void visit(PlayController playController) {
        this.play(playController);
        playController.nextStage();
    }

	public boolean visit(ResumeController resumeController){
        this.resume(resumeController);
        resumeController.nextStage();    
        return true;
    }
}
