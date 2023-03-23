package connect4;

import java.io.FileNotFoundException;
import java.io.IOException;

import connect4.models.Board;
import connect4.models.Turn;
import connect4.utils.Language;
import connect4.utils.MessageManager;
import connect4.utils.YesNoDialog;
import connect4.views.BoardView;
import connect4.views.TurnView;
import connect4.views.menu.Connect4Menu;

public class Connect4 {

    private final Board board;
    private final Turn turn;
    private final BoardView boardView;
    private final TurnView turnView;
    private final Connect4Menu connect4Menu;
    private MessageManager messageManager;
    private final String relativePath = "resources/";

    public Connect4() throws FileNotFoundException, IOException {
        this.board = new Board();
        this.boardView = new BoardView(this.board);
        this.turn = new Turn(this.board);
        this.turnView = new TurnView(this.turn);
        this.connect4Menu = new Connect4Menu(this);
        this.messageManager = MessageManager.getInstance(this.relativePath);
        this.messageManager.setLanguage(Language.ENGLISH);
    }

    private void run() {
        do {
            this.playGame();
        } while (this.isResumed());
    }

    private void playGame() {
        this.messageManager.writeln("GAME_TITLE");
        this.connect4Menu.interact();
        this.boardView.paintBoard();
        do {
            this.turnView.play();
            this.boardView.paintBoard();
        } while (!this.board.isGameFinished());
        this.turnView.writeResult();
    }

    private boolean isResumed() {
        final YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(this.messageManager.getMessage("RESUME"));
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
        }
        return yesNoDialog.isAffirmative();
    }

    public static void main(final String[] args) throws FileNotFoundException, IOException {
        new Connect4().run();
    }

    public Turn getTurn() {
        return this.turn;
    }

}
