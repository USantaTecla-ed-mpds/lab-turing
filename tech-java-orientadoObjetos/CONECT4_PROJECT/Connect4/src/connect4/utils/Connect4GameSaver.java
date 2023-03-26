package connect4.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import connect4.Connect4;
import connect4.models.Board;
import connect4.models.Turn;

public class Connect4GameSaver {

    private final String savedGamesPath = "history/";
    private final String savedGameExtension = ".history";
    private Connect4 connect4;

    public Connect4GameSaver(Connect4 connect4) {
        this.connect4 = connect4;
    }

    public void saveGame(final String fileName) throws IOException {
        final String historyPath = this.savedGamesPath + fileName + this.savedGameExtension;
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(historyPath))) {
            oos.writeObject(this.connect4.getBoard());
            oos.writeObject(this.connect4.getTurn());
        }
    }

    public void loadGame(final String fileName) throws IOException, ClassNotFoundException {
        final String historyPath = this.savedGamesPath + fileName + this.savedGameExtension;
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(historyPath))) {
            this.connect4.setBoard((Board) ois.readObject());
            this.connect4.setTurn((Turn) ois.readObject());

        }
    }

}