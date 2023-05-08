package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Color;
import main.es.labturing.connect4.models.Game;
import main.es.labturing.connect4.models.GameState;
import main.es.labturing.connect4.models.MachinePlayer;
import main.es.labturing.connect4.types.PlayerType;

public class PlayController extends Controller {

    public PlayController(Game game) {
        super(game);
    }

    public void play(int column) {
        this.game.getTurn().play(column);
    }

    public boolean isWinner() {
        return this.game.getBoard().isWinner();
    }

    public int getActiveMachineColumn() {
        MachinePlayer machinePlayer = (MachinePlayer) this.game.getTurn().getActivePlayer();
        return machinePlayer.getColumn();
    }

    public PlayerType getActivePlayerType() {
        return this.game.getTurn().getActivePlayer().getType();
    }

    public Color getActivePlayerColor() {
        return this.game.getTurn().getActivePlayer().getColor();
    }

    public boolean isActivePlayerComplete(int column) {
        return this.game.getTurn().getActivePlayer().isComplete(column);
    }

    public boolean isGameFinished() {
        return this.game.getBoard().isGameFinished();
    }

    public GameState getState() {
        return this.game.getState();
    }

}
