package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Game;
import main.es.labturing.connect4.views.console.BoardView;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.connect4.views.console.menu.LanguageMenu;

public class StartController extends Controller {

    public StartController(Game game) {
        super(game);
        new LanguageMenu("SELECT LANGUAGE:").interact();
    }

    public void interact(BoardView boardView) {
        // new GameMenu(this).interact();
        MessageManager.getInstance().writeln("GAME_TITLE");
        boardView.writeln();
    }

}
