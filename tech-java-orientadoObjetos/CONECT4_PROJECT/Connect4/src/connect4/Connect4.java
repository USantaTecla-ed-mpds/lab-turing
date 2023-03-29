package connect4;

import java.io.FileNotFoundException;
import java.io.IOException;
import connect4.models.Board;
import connect4.models.GameData;
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
    private MessageManager messageManager;
    private GamesManager gamesManager;

    public Connect4() throws IOException, MessageNotFoundException {
        // Initialize Games Save / Restore manager
        this.gamesManager = new GamesManager(this);

        // Configure Messages
        this.messageManager = MessageManager.getInstance();
        this.messageManager.initialize(Language.SPANISH);

        // Configure Game board and turns
        this.board = new Board();
        this.boardView = new BoardView(this.board);
        this.turn = new Turn(this.board);
        this.turnView = new TurnView(this);

        // Configure Games Save / Restore manager
        GameData gameData = new GameData();
        gameData.setBoard(board);
        gameData.setTurn(turn);
        this.gamesManager.setGameData(gameData);
    }

    public static void main(final String[] args)
            throws FileNotFoundException, IOException, MessageNotFoundException {
        new Connect4().run();
    }

    // ------------------ GAME FLOW --------------------------//
    private void run() {
        try {
            new Connect4Menu(this.messageManager.getMessage("GAME_TITLE"), this).interact();
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

    private boolean isResumed() throws MessageNotFoundException, IOException, ClassNotFoundException {
        final YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.show(MessageManager.getInstance().getMessage("RESUME"));
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
            this.turn.resetPlayers();
        } 
        return yesNoDialog.isAffirmative();
    }
    // ------------------ GAME FLOW --------------------------//

    // Used From Connect4 option's to save
    public void showSaveGameDialog() throws MessageNotFoundException, IOException, ClassNotFoundException {
        final YesNoDialog saveDialog = new YesNoDialog();
        saveDialog.show(MessageManager.getInstance().getMessage("SAVE_GAME"));
        if (saveDialog.isAffirmative()) {
            final String fileName = Console.getInstance()
                    .readString(MessageManager.getInstance().getMessage("ENTER_FILE_NAME"));
            try {
                this.gamesManager.saveGame(fileName);
            } catch (FileNotFoundException fileNotFoundException) {
                Console.getInstance().writeln("Error: Fichero no encontrado!!!");
            } catch (IOException iOException) {
                Console.getInstance().writeln(
                        "Error: Error al guardar partida:"
                                + iOException.getMessage());
            }
        }
        new Connect4Menu(this.messageManager.getMessage("GAME_TITLE"), this).interact();
    }

    // Used From Connect4 option's to load
    public void showLoadGameDialog()
            throws ClassNotFoundException, IOException, MessageNotFoundException {
        final String fileName = Console.getInstance()
                .readString(MessageManager.getInstance().getMessage("ENTER_FILE_NAME"));
        try {
            this.gamesManager.loadGame(fileName);
        } catch (FileNotFoundException fileNotFoundException) {
            Console.getInstance().writeln("Error: Fichero no encontrado!!!");
        } catch (MessageNotFoundException messageNotFoundException) {
            Console.getInstance().writeln(
                    "Error: Mensaje no encontrado en fichero de resources:" + messageNotFoundException.getMessage());
        } catch (ClassNotFoundException classNotFoundException) {
            Console.getInstance().writeln("Error: Cargando classes: " + classNotFoundException.getMessage());
        }
        new Connect4Menu(this.messageManager.getMessage("GAME_TITLE"), this).interact();
    }

    // Used by GamesManager
    public void loadGameView(Board board, Turn turn) throws MessageNotFoundException {
        this.turn = turn;
        this.board = board;
        this.boardView = new BoardView(board);
        this.turnView = new TurnView(this);
        GameData gameData = new GameData();
        gameData.setBoard(board);
        gameData.setTurn(turn);
        this.gamesManager.setGameData(gameData);
    }

    public Turn getTurn() {
        return this.turn;
    }

    public GamesManager getGamesManager() {
        return this.gamesManager;
    }

}
