package main.es.labturing.connect4.daos;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import main.es.labturing.connect4.models.Game;


class GameDAO implements DAO {

    private Game game;

    private BoardDAO boardDAO;

    private TurnDAO turnDAO;

    GameDAO(Game game) {
        this.game = game;
        this.boardDAO = new BoardDAO(this.game.getBoard());
        this.turnDAO = new TurnDAO(this.game.getTurn());
	}

    public void save(FileOutputStream fileOutputStream) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(this.game.getBoard());
           // this.turnDAO.save(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(BufferedReader bufferedReader) {
        try {
            this.boardDAO.load(bufferedReader);
            int typeFirstPlayer = Integer.parseInt(bufferedReader.readLine());
            int tokenFirstPlayer = Integer.parseInt(bufferedReader.readLine());
            this.game.setPlayerByIndex(new Player(Token.values()[tokenFirstPlayer], this.game.getBoard(),
            PlayerType.values()[typeFirstPlayer]), 0);
            int typeSecondPlayer = Integer.parseInt(bufferedReader.readLine());
            int tokenSecondPlayer = Integer.parseInt(bufferedReader.readLine());
            this.game.setPlayerByIndex(new Player(Token.values()[tokenSecondPlayer], this.game.getBoard(),
            PlayerType.values()[typeSecondPlayer]), 1);
            this.turnDAO.load(bufferedReader);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}