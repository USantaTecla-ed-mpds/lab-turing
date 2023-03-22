package main.es.pbover.connect4;

import java.io.FileNotFoundException;
import java.io.IOException;

import es.usantatecla.tictactoe_v2.utils.Console;
import main.es.pbover.connect4.models.Board;
import main.es.pbover.connect4.models.Language;
import main.es.pbover.connect4.models.Message;
import main.es.pbover.connect4.models.MessageManager;
import main.es.pbover.connect4.models.Turn;
import main.es.pbover.connect4.views.BoardView;
import main.es.pbover.connect4.views.MessageView;
import main.es.pbover.connect4.views.TurnView;
import main.es.pbover.connect4.views.menu.Connect4Menu;
import main.es.pbover.utils.YesNoDialog;

public class Connect4 {

    private final Board board;
    private final Turn turn;
    private final BoardView boardView;
    private final TurnView turnView;
    private final Connect4Menu connect4Menu;
    private MessageManager messageManager;

    public Connect4() throws FileNotFoundException, IOException {
        this.board = new Board();
        this.boardView = new BoardView(this.board);
        this.turn = new Turn(this.board);
        this.turnView = new TurnView(this.turn);
        this.connect4Menu =  new Connect4Menu(this);
        this.messageManager = MessageManager.getInstance();
        this.messageManager.setLanguage(Language.ENGLISH);
    }

    private void run(){
        do {
            this.playGame();
        } while (this.isResumed());
    }

    private void playGame() {
        Console.getInstance().writeln(this.messageManager.getMessage("GAME_TITLE"));
        this.connect4Menu.interact();
        //MessageView.getInstance().writeln(Message.GAME_TITLE);
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

    public static void main(final String[] args) throws FileNotFoundException, IOException{
        new Connect4().run();
    }

    public Turn getTurn(){
        return this.turn;
    }

}
