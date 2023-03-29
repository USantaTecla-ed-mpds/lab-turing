package main.es.pbover.connect4.views;

import main.es.pbover.connect4.models.Game;
import main.es.pbover.connect4.views.menu.LanguageMenu;
import main.es.pbover.utils.YesNoDialog;

public class GameView {

    private Game game;
    private BoardView boardView;
    private TurnView turnView;

    
    public GameView(Game game)  {
        this.boardView = new BoardView(game.getBoard());
        this.turnView = new TurnView(game.getTurn());
        this.game = game;
    }

    public void start() {
        new LanguageMenu("SELECT LANGUAGE:").interact();
       // new GameMenu(this).interact();
    }

     public void play() {
        this.turnView.configTurn();
        MessageManager.getInstance().writeln("GAME_TITLE");
        this.boardView.writeln();

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
        }
        return yesNoDialog.isAffirmative();
    }
    
}
