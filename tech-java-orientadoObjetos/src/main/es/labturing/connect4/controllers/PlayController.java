package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Game;
import main.es.labturing.connect4.views.console.BoardView;
import main.es.labturing.connect4.views.console.TurnView;

public class PlayController extends Controller {

    public PlayController(Game game) {
        super(game);
    }

    public void interact(TurnView turnView, BoardView boardView) {
        do {
            turnView.play();
            boardView.writeln();
        } while (!boardView.isGameFinished());
        turnView.writeResult();
    }

}
