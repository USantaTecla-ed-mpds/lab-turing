package connect4.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import connect4.Connect4;
import connect4.utils.Console;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.BoardView;
import connect4.views.MessageManager;
import connect4.views.TurnView;
import connect4.views.dialog.YesNoDialog;

public class GamesManager {

    private final String savedGamesPath = "history/";
    private final String savedGameExtension = ".history";
    private static GamesManager instance;

    private Connect4 connect4;
    private Turn turn;
    private Board board;

    private GamesManager() {
    }

    public static GamesManager getInstance() {
        if (instance == null) {
            instance = new GamesManager();
        }
        return instance;
    }

    public void initalize(Connect4 connect4) {
        this.connect4 = connect4;

    }

    private void saveGame(final String fileName) throws IOException {
        final String historyPath = this.savedGamesPath + fileName + this.savedGameExtension;
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(historyPath))) {
            oos.writeObject(this.board);
            oos.writeObject(this.turn);
        }
    }

    private void loadGame(final String fileName) throws IOException, ClassNotFoundException, MessageNotFoundException {
        final String historyPath = this.savedGamesPath + fileName + this.savedGameExtension;
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(historyPath))) {
            this.connect4.loadGameView((Board) ois.readObject(), (Turn) ois.readObject());
        }
    }

    public void showSaveGameDialog() throws MessageNotFoundException, IOException {
        final YesNoDialog saveDialog = new YesNoDialog();
        saveDialog.show(MessageManager.getInstance().getMessage("SAVE_GAME"));
        if (saveDialog.isAffirmative()) {
            final String fileName = Console.getInstance()
                    .readString(MessageManager.getInstance().getMessage("ENTER_FILE_NAME"));
            this.saveGame(fileName);
        }
    }

    public void showLoadGameDialog()
            throws ClassNotFoundException, IOException, MessageNotFoundException {
        final String fileName = Console.getInstance()
                .readString(MessageManager.getInstance().getMessage("ENTER_FILE_NAME"));
        this.loadGame(fileName);
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

}