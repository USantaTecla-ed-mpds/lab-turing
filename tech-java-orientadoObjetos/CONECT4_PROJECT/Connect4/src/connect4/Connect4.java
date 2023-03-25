package connect4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import connect4.models.Board;
import connect4.models.Turn;
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
    private final Connect4Menu connect4Menu;
    private MessageManager messageManager;
    private final String resourcesPath = "resources/";
    private final String savedGamesPath = "history/";

    public Connect4() throws IOException, MessageNotFoundException {
        this.messageManager = MessageManager.getInstance();
        this.messageManager.setPath(this.resourcesPath);
        this.messageManager.setLanguage(Language.SPANISH);

        this.board = new Board();
        this.boardView = new BoardView(this.board);
        this.turn = new Turn(this.board);
        this.turnView = new TurnView(this.turn);
        this.connect4Menu = new Connect4Menu(this);

    }

    private void run() {

        try {

            do {
                this.playGame();
            } while (this.isResumed());

        } catch (MessageNotFoundException messageNotFoundException) {
            Console.getInstance().writeln(messageNotFoundException.getMessage());
        } catch (Exception exception) {
            Console.getInstance().writeln(exception.getMessage());
        }

    }

    private void playGame() throws MessageNotFoundException, IOException, ClassNotFoundException {
        this.messageManager.writeln("GAME_TITLE");
        this.connect4Menu.interact();
        this.boardView.paintBoard();
        do {
            this.turnView.play();
            this.boardView.paintBoard();

            final YesNoDialog saveDialog = new YesNoDialog();
            saveDialog.show(this.messageManager.getMessage("SAVE_GAME"));
            if (saveDialog.isAffirmative()) {
                final String fileName = Console.getInstance()
                        .readString(this.messageManager.getMessage("ENTER_FILE_NAME"));
                this.saveGame(fileName);
            }
        } while (!this.board.isGameFinished());
        this.turnView.writeResult();
    }

    private boolean isResumed() throws MessageNotFoundException {
        final YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.show(this.messageManager.getMessage("RESUME"));
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
        }
        return yesNoDialog.isAffirmative();
    }

    public static void main(final String[] args) throws FileNotFoundException, IOException, MessageNotFoundException {
        new Connect4().run();
    }

    public Turn getTurn() {
        return this.turn;
    }

    public void saveGame(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savedGamesPath + fileName))) {
            oos.writeObject(board);
            oos.writeObject(turn);
        }
    }

    public void loadGame(String fileName) throws IOException, ClassNotFoundException {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedGamesPath + fileName))) {
            board = (Board) ois.readObject();
            turn = (Turn) ois.readObject();
            this.boardView = new BoardView(board);
            this.turnView = new TurnView(turn);
        }
    }

}
