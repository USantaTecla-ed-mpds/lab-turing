package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Game;
import main.es.labturing.connect4.types.PlayerType;
import main.es.labturing.connect4.models.Color;
import main.es.labturing.connect4.models.Coordinate;

public class StartController extends Controller {

    public StartController(Game game) {
        super(game);
    }

    public void addPlayer(PlayerType playerType) {
        this.game.getTurn().addPlayer(playerType);
    }

    public void resetPlayers() {
        this.game.getTurn().resetPlayers();
    }

    public void resetPlayersIndex () {
        this.game.getTurn().resetPlayersIndex();;
    }

    public int getNumberPlayers() {
        return this.game.getTurn().getNumberPlayers();
    }

    public Color getBoardColor(Coordinate coordinate) {
        return this.game.getBoard().getColor(coordinate);
    }

}
