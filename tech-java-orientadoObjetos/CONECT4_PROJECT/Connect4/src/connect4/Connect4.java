package connect4;

import java.io.FileNotFoundException;
import java.io.IOException;
import connect4.models.Board;
import connect4.models.Turn;
import connect4.utils.Connect4GameSaver;
import connect4.utils.Console;
import connect4.utils.Language;
import connect4.utils.MessageManager;
import connect4.utils.YesNoDialog;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.BoardView;
import connect4.views.TurnView;
import connect4.views.menu.Connect4Menu;

public class Connect4 {

    private Board board;
    private Turn turn;
    private BoardView boardView;
    private TurnView turnView;
    private Connect4Menu connect4Menu;
    private final MessageManager messageManager;
    private final String resourcesPath = "resources/";

    private Connect4GameSaver connect4GameSaver;

    public Connect4() throws IOException, MessageNotFoundException {
        this.messageManager = MessageManager.getInstance();
        this.messageManager.setPath(this.resourcesPath);
        this.messageManager.setLanguage(Language.SPANISH);
        this.board = new Board();
        this.boardView = new BoardView(this.board);
        this.turn = new Turn(this.board);
        this.turnView = new TurnView(this);
        this.connect4Menu = new Connect4Menu(this);
        this.connect4GameSaver = new Connect4GameSaver(this);
    }

    private void run() {
        try {
            this.connect4Menu = new Connect4Menu(this);
            this.board.reset();
            this.showMainMenu();
        } catch (final MessageNotFoundException messageNotFoundException) {
            Console.getInstance().writeln(messageNotFoundException.getMessage());
        } catch (final Exception exception) {
            Console.getInstance().writeln(exception.getMessage());
        }

    }

    private void showMainMenu() throws MessageNotFoundException, IOException, ClassNotFoundException {
        this.messageManager.writeln("GAME_TITLE");
        this.connect4Menu.interact();
    }

    public void play() throws MessageNotFoundException, IOException, ClassNotFoundException {
        this.boardView.paintBoard();
        do {
            this.turnView.play();
            this.boardView.paintBoard();
        } while (!this.board.isGameFinished());
        this.turnView.writeResult();
    }

    public void checkExit() throws MessageNotFoundException {
        final YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.show(this.messageManager.getMessage("ASK_EXIT"));
        if (yesNoDialog.isAffirmative()) {
            System.exit(0);
        } else
            this.run();
    }

    public static void main(final String[] args)
            throws FileNotFoundException, IOException, MessageNotFoundException {
        new Connect4().run();
    }

    public void saveGame() throws MessageNotFoundException, IOException {
        final YesNoDialog saveDialog = new YesNoDialog();
        saveDialog.show(this.messageManager.getMessage("SAVE_GAME"));
        if (saveDialog.isAffirmative()) {
            final String fileName = Console.getInstance()
                    .readString(this.messageManager.getMessage("ENTER_FILE_NAME"));
            this.connect4GameSaver.saveGame(fileName);
        }
    }

    public void loadGame(String resourcesPath) throws ClassNotFoundException, IOException {
        this.connect4GameSaver.loadGame(resourcesPath);
    }

    public Turn getTurn() {
        return this.turn;
    }

    public Board getBoard() {
        return this.board;
    }

    public BoardView getBoardView() {
        return this.boardView;
    }

    public TurnView getTurnView() {
        return this.turnView;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
        this.turnView = new TurnView(this);
    }

    public void setBoard(Board board) {
        this.board = board;
        this.boardView = new BoardView(board);
    }

}
