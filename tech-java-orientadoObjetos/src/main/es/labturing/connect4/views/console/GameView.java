package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.ResumeController;
import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.models.Game;
import main.es.labturing.connect4.views.console.menu.LanguageMenu;
import main.es.labturing.utils.views.YesNoDialog;

public class GameView extends main.es.labturing.utils.framework.GameView<Game> {

    private BoardView boardView;
    private TurnView turnView;

    public GameView(StartController startController, PlayController playController, ResumeController resumeController) {
        super(startController,playController,resumeController);
        new LanguageMenu("SELECT LANGUAGE:").interact();
        this.boardView = new BoardView(game.getBoard());
        this.turnView = new TurnView(game.getTurn());

    }

    public void start() {  
        // new GameMenu(this).interact();
        MessageManager.getInstance().writeln("GAME_TITLE");
        this.boardView.writeln();
    }

    public void play() {
        do {
            this.turnView.play();
            this.boardView.writeln();
        } while (!this.boardView.isGameFinished());
        this.turnView.writeResult();
    }

    public boolean resume() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(MessageManager.getInstance().getMessage("RESUME"));
        if (yesNoDialog.isAffirmative()) {
            this.game.reset();
            this.turnView.configTurn();
        }
        return yesNoDialog.isAffirmative();
    }

}
