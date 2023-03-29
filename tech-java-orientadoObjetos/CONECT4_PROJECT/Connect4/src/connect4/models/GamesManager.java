package connect4.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import connect4.Connect4;
import connect4.utils.exceptions.MessageNotFoundException;

public class GamesManager {

    private final String savedGamesPath = "history/";
    private final String savedGameExtension = ".history";
    private GameData gameData;

    private Connect4 connect4;

    public GamesManager(Connect4 connect4) {
        this.connect4 = connect4;
    }

    public void saveGame(final String fileName) throws IOException {
        final String historyPath = this.savedGamesPath + fileName + this.savedGameExtension;
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(historyPath))) {
            oos.writeObject(this.gameData.getBoard());
            oos.writeObject(this.gameData.getTurn());
        }
    }

    public void loadGame(final String fileName) throws IOException, ClassNotFoundException, MessageNotFoundException {
        final String historyPath = this.savedGamesPath + fileName + this.savedGameExtension;
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(historyPath))) {
            this.connect4.loadGameView((Board) ois.readObject(), (Turn) ois.readObject());
        }
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

}