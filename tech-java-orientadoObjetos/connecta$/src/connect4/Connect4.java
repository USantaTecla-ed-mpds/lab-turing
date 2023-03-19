package connect4;

import connect4.utils.YesNoDialog;
import connect4.models.Board;
import connect4.models.Message;
import connect4.models.Turn;
import connect4.views.BoardView;
import connect4.views.MessageView;
import connect4.views.TurnView;

public class Connect4 {

    private final Board board;
    private final Turn turn;
    private final BoardView boardView;
    private final TurnView turnView;

    public Connect4() {
        this.board = new Board();
        this.boardView = new BoardView(this.board);
        this.turn = new Turn(this.board);
        this.turnView = new TurnView(this.turn);

    }

    private void run() {
        do {
            this.playGame();
        } while (this.isResumed());
    }

    private void playGame() {

        this.turnView.initPlayers();
        MessageView.getInstance().writeln(Message.GAME_TITLE);
        this.boardView.paintBoard();

        do {
            this.turnView.play();
            this.boardView.paintBoard();
        } while (!this.board.isGameFinished());
        this.turnView.writeResult();
    }

    private boolean isResumed() {
        final YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
        }
        return yesNoDialog.isAffirmative();
    }

    public static void main(final String[] args) {
        new Connect4().run();
    }

}
