package connect4;

import connect4.utils.YesNoDialog;
import connect4.models.Board;
import connect4.models.Message;
import connect4.models.Turn;
import connect4.views.BoardView;
import connect4.views.TurnView;

public class Connect4 {

    private Board board;
    private Turn turn;
    private BoardView boardView;
    private TurnView turnView;

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

        Message.TITLE.writeln();
        this.boardView.writeln();

        do {
            this.turnView.play();
            this.boardView.writeln();
        } while (!this.board.isFinished());
        this.turnView.writeResult();
    }

    private boolean isResumed() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
        }
        return yesNoDialog.isAffirmative();
    }

    public static void main(String[] args) {
        new Connect4().run();
    }

}
