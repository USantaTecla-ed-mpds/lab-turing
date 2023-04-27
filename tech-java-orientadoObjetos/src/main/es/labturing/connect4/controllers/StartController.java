package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Game;
import main.es.labturing.connect4.models.Player;
import main.es.labturing.connect4.models.HumanPlayer;
import main.es.labturing.connect4.models.MinMaxPlayer;
import main.es.labturing.connect4.models.RandomPlayer;
import main.es.labturing.connect4.models.Color;
import main.es.labturing.connect4.models.Coordinate;

public class StartController extends Controller {

    public StartController(Game game) {
        super(game);
    }

    private void addPlayer(Player player) {
        this.game.getTurn().addPlayer(player);
    }

    public void addHumanPlayer() {
        this.addPlayer(new HumanPlayer(this.game.getBoard()));
    }

    public void addRandomPlayer() {
        this.addPlayer(new RandomPlayer(this.game.getBoard()));
    }

    public void addMinMaxPlayer() {
        this.addPlayer(new MinMaxPlayer(this.game.getBoard()));
    }

    public void resetPlayersIndex() {
        this.game.getTurn().reset();
    }

    public int getNumberPlayers() {
        return this.game.getTurn().getNumberPlayers();
    }

    public Color getBoardColor(Coordinate coordinate) {
        return this.game.getBoard().getColor(coordinate);
    }

}
