package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.ResumeController;
import main.es.labturing.connect4.controllers.SaveController;
import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.types.StageValue;
import main.es.labturing.connect4.views.console.menu.GameMenu;
import main.es.labturing.connect4.views.console.menu.LanguageMenu;

import main.es.labturing.utils.views.Console;

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
        startController.nextStage();
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
            playController.setStageValue(StageValue.RESUME);
        }
        
    }

    private void saveAndOrExit(SaveController saveController){
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(MessageManager.getInstance().getMessage("SAVE"));
        String name = null;
		if (yesNoDialog.isAffirmative()) {
			if (saveController.hasName()) {
				saveController.save();
			} else {
				boolean exists = false;
				do {
					name = Console.getInstance().readString(MessageManager.getInstance().getMessage("GAME_NAME"));
					exists = saveController.exists(name);
					if (exists) {
						Console.getInstance().writeln(MessageManager.getInstance().getMessage("ERROR_GAME_NAME"));
					}
				} while (exists);
				saveController.save(name);
			}
		}
		saveController.nextStage();
    }

    private void resume(ResumeController resumeController) {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(MessageManager.getInstance().getMessage("RESUME"));
        if (yesNoDialog.isAffirmative()) {
            resumeController.reset();
        } else {
            resumeController.setStageValue(StageValue.EXIT);
        }
    }

    @Override
    public void visit(StartController startController) {
        this.start(startController);

    }

    @Override
    public void visit(PlayController playController) {
        this.play(playController);
    }

    @Override
    public void visit(SaveController saveController) {
        this.saveAndOrExit(saveController);
    }

    @Override
    public void visit(ResumeController resumeController) {
        this.resume(resumeController);
    }
}
