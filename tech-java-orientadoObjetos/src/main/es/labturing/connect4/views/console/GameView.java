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

    private void saveAndOrExit(SaveController saveController){
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read("¿quiere salvar?_MESSAGE");
        String name = null;
		if (yesNoDialog.isAffirmative()) {
			if (saveController.hasName()) {
				saveController.save();
			} else {
				boolean exists = false;
				do {
					name = Console.getInstance().readString("Ponga el nombre del archivo_MESSAGE");
					exists = saveController.exists(name);
					if (exists) {
						Console.getInstance().writeln("Archivo ya existe_MESSAGE");
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
            resumeController.setStage(StageValue.EXIT);
        }
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
    public void visit(SaveController saveController) {
        this.saveAndOrExit(saveController);
        //AQUI GESTIONAR EL STAGE... A EXIT DIRECTAMENTE?
    }

    @Override
    public void visit(ResumeController resumeController) {
        this.resume(resumeController);
    }
}
