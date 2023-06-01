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

    public void save(FileWriter fileWriter) {
            this.boardDAO.save(fileWriter);
            this.turnDAO.save(fileWriter);
    }

    public void load(BufferedReader bufferedReader) {
            this.boardDAO.load(bufferedReader);
            this.turnDAO.load(bufferedReader);
    }

}