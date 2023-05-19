package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.GameState;
import main.es.labturing.connect4.models.Session;
import main.es.labturing.connect4.types.Color;
import main.es.labturing.connect4.types.PlayerType;
import main.es.labturing.utils.framework.AcceptorController;
import main.es.labturing.utils.framework.ControllersVisitor;

public class PlayController extends Controller implements AcceptorController {

    public PlayController(Session session) {
        super(session);
    }

    public void play(int column) {
        this.session.play(column);
    }

    public boolean isWinner() {
        return this.session.isWinner();
    }

    public int getActiveMachineColumn() {
        return this.session.getActiveMachineColumn();
    }

    public PlayerType getActivePlayerType() {
        return this.session.getActivePlayerType();
    }

    public Color getActivePlayerColor() {
        return this.session.getActivePlayerColor();
    }

    public boolean isColumnComplete(int column) {
        return this.session.isColumnComplete(column);
    }

    public boolean isGameFinished() {
        return this.session.isGameFinished();
    }

    public GameState getState() {
        return this.session.getState();
    }

    public void accept(ControllersVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void nextStage() {
        this.session.nextStage();
    }

}
