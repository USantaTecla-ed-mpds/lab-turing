package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Game;
import main.es.labturing.connect4.models.GameState;
import main.es.labturing.connect4.types.Color;
import main.es.labturing.connect4.types.PlayerType;
import main.es.labturing.utils.framework.AcceptorController;
import main.es.labturing.utils.framework.ControllersVisitor;

public class PlayController extends Controller implements AcceptorController {

    public PlayController(Game game) {
        super(game);
    }

    public void play(int column) {
        this.game.play(column);
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public int getActiveMachineColumn() {
        return this.game.getActiveMachineColumn();
    }

    public PlayerType getActivePlayerType() {
        return this.game.getActivePlayerType();
    }

    public Color getActivePlayerColor() {
        return this.game.getActivePlayerColor();
    }

    public boolean isColumnComplete(int column) {
        return this.game.isColumnComplete(column);
    }

    public boolean isGameFinished() {
        return this.game.isGameFinished();
    }

    public GameState getState() {
        return this.game.getState();
    }

    public void accept(ControllersVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void nextStage() {
    }

}
