package main.es.pbover.connect4;

import java.io.FileNotFoundException;
import java.io.IOException;

import main.es.pbover.connect4.models.Board;
import main.es.pbover.connect4.models.GameManager;
import main.es.pbover.connect4.models.Turn;
import main.es.pbover.connect4.views.BoardView;
import main.es.pbover.connect4.views.TurnView;

import main.es.pbover.connect4.views.MessageManager;
import main.es.pbover.connect4.views.menu.Connect4Menu;
import main.es.pbover.connect4.views.menu.LanguageMenu;
import main.es.pbover.utils.YesNoDialog;

public class Connect4 {

    private Board board;
    private Turn turn;
    private BoardView boardView;
    private TurnView turnView;

    private final GameManager gameManager;

    public Connect4() throws FileNotFoundException, IOException {
        this.board = new Board();
        this.boardView = new BoardView(this.board);
        this.turn = new Turn(this.board);
        this.gameManager = new GameManager(this.board,this.turn);
        this.turnView = new TurnView(this.turn,this.gameManager);
        
    }

    private void run() {
        new LanguageMenu("SELECT LANGUAGE:").interact();
        new Connect4Menu(this).interact();
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

    public GameManager getGameManager(){
        return this.gameManager;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public static void main(final String[] args) throws FileNotFoundException, IOException {
        new Connect4().run();
    }

}
