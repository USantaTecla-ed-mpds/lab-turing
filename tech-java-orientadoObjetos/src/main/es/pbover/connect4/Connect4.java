package main.es.pbover.connect4;

import main.es.pbover.connect4.models.Board;
import main.es.pbover.connect4.models.Turn;
import main.es.pbover.connect4.views.BoardView;
import main.es.pbover.connect4.views.Message;
import main.es.pbover.connect4.views.TurnView;
import main.es.pbover.utils.YesNoDialog;

public class Connect4 {
    
    private Board board;
    private Turn turn;
    private BoardView boardView;
    private TurnView turnView;

    public Connect4(){
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
        this.turnView.getMachineTypePlayer();
        this.turnView.getNumberOfHumanPlayers();
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



