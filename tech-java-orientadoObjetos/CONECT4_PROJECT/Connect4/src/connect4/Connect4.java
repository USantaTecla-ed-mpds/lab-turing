package connect4;

import java.io.FileNotFoundException;
import java.io.IOException;
import connect4.models.Board;
import connect4.models.GamesManager;
import connect4.models.Turn;
import connect4.utils.Console;
import connect4.utils.Language;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.BoardView;
import connect4.views.MessageManager;
import connect4.views.TurnView;
import connect4.views.dialog.YesNoDialog;
import connect4.views.menu.Connect4Menu;

public class Connect4 {

    private Board board;
    private Turn turn;
    private BoardView boardView;
    private TurnView turnView;
    private final MessageManager messageManager;
    private final String resourcesPath = "resources/";

    private GamesManager gamesManager;

    public Connect4() throws IOException, MessageNotFoundException {

        // Configure Messages
        this.messageManager = MessageManager.getInstance();
        this.messageManager.initialize(this.resourcesPath, Language.SPANISH);

        // Configure Game board and turns
        this.board = new Board();
        this.boardView = new BoardView(this.board);
        this.turn = new Turn(this.board);
        this.turnView = new TurnView(this, this.turn);

        // Configure Games Save / Restore manager
        this.gamesManager = GamesManager.getInstance();
        this.gamesManager.initalize(this);
        this.gamesManager.setTurn(this.turn);
        this.gamesManager.setBoard(this.board);

    }

    public static void main(final String[] args)
            throws FileNotFoundException, IOException, MessageNotFoundException {
        new Connect4().run();
    }

    private void run() {
        try {
            this.messageManager.writeln("GAME_TITLE");
            new Connect4Menu(this).interact();
        } catch (final MessageNotFoundException messageNotFoundException) {
            Console.getInstance().writeln(messageNotFoundException.getMessage());
        } catch (final Exception exception) {
            Console.getInstance().writeln(exception.getMessage());
        }
    }

    public void play(boolean configureTurns) throws MessageNotFoundException, ClassNotFoundException, IOException {
        do {
            if (configureTurns)
                this.turnView.configTurn();
            this.playGame();
        } while (this.isResumed());
    }

    private void playGame() throws MessageNotFoundException, IOException, ClassNotFoundException {
        this.boardView.paintBoard();
        do {
            this.turnView.play();

            this.boardView.paintBoard();
        } while (!this.board.isGameFinished());
        this.turnView.writeResult();
    }

    private boolean isResumed() throws MessageNotFoundException, IOException {
        final YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.show(MessageManager.getInstance().getMessage("RESUME"));
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
            this.turn.resetPlayers();
        } else
            this.gamesManager.showSaveGameDialog();
        return yesNoDialog.isAffirmative();
    }

    public void loadGameView(Board board, Turn turn) throws MessageNotFoundException {
        this.turn = turn;
        this.board = board;
        this.boardView = new BoardView(board);
        this.turnView = new TurnView(this, turn);
    }

}
