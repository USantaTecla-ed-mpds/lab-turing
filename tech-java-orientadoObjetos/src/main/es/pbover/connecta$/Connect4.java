package main.es.pbover.connecta$;

import main.es.pbover.connecta$.models.Board;
import main.es.pbover.connecta$.models.Turn;
import main.es.pbover.connecta$.models.Message;

import main.es.pbover.connecta$.views.BoardView;
import main.es.pbover.connecta$.views.TurnView;
import main.es.pbover.connecta$.views.menu.Connect4Menu;
import main.es.pbover.connecta$.views.MessageView;
import main.es.pbover.utils.YesNoDialog;

public class Connect4 {

    private final Board board;
    private final Turn turn;
    private final BoardView boardView;
    private final TurnView turnView;
    private final Connect4Menu connect4Menu;

    public Connect4() {
        this.board = new Board();
        this.boardView = new BoardView(this.board);
        this.turn = new Turn(this.board);
        this.turnView = new TurnView(this.turn);
        this.connect4Menu =  new Connect4Menu(this);

    }

    private void run() {
        do {
            this.playGame();
        } while (this.isResumed());
    }

    private void playGame() {
        this.connect4Menu.interact();
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

    public Turn getTurn(){
        return this.turn;
    }

}
