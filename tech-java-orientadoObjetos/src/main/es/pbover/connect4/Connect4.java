package main.es.pbover.connect4;

import java.io.FileNotFoundException;
import java.io.IOException;

import main.es.pbover.connect4.models.Board;
import main.es.pbover.connect4.models.Turn;
import main.es.pbover.connect4.views.BoardView;
import main.es.pbover.connect4.views.TurnView;

import main.es.pbover.connect4.views.Language;
import main.es.pbover.connect4.views.MessageManager;
import main.es.pbover.connect4.views.menu.Connect4Menu;
import main.es.pbover.utils.YesNoDialog;

public class Connect4 {

    private final Board board;
    private final Turn turn;
    private final BoardView boardView;
    private final TurnView turnView;

    public Connect4() throws FileNotFoundException, IOException {
        MessageManager.getInstance().setLanguage(Language.SPANISH);
        this.board = new Board();
        this.boardView = new BoardView(this.board);
        this.turn = new Turn(this.board);
        this.turnView = new TurnView(this.turn);

    }

    private void run() {

        Connect4Menu connect4Menu = new Connect4Menu(this);
        connect4Menu.interact();

    }

    public void playGames() {
        do {
            this.playGame();
        } while (this.isResumed());
    }

    private void playGame() {
        this.turnView.configTurn();
        MessageManager.getInstance().writeln("GAME_TITLE");
        this.boardView.writeln();

        do {
            this.turnView.play();
            this.boardView.writeln();
        } while (!this.board.isGameFinished());
        this.turnView.writeResult();
    }

    private boolean isResumed() {
        final YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(MessageManager.getInstance().getMessage("RESUME"));
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
            this.turn.resetPlayers();
        }
        return yesNoDialog.isAffirmative();
    }

    public static void main(final String[] args) throws FileNotFoundException, IOException {
        new Connect4().run();
    }

}
