package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.GameState;
import main.es.labturing.connect4.models.Session;
import main.es.labturing.connect4.models.Stage;
import main.es.labturing.connect4.types.Color;
import main.es.labturing.connect4.types.PlayerType;
import main.es.labturing.connect4.types.StageValue;
import main.es.labturing.utils.framework.AcceptorController;
import main.es.labturing.utils.framework.ControllersVisitor;

public class PlayController extends Controller implements AcceptorController {

    private PlayerActionsController playerActionsController;

    public PlayController(Session session) {
        super(session);
        this.playerActionsController = new PlayerActionsController(session);
    }

    public PlayerType getActivePlayerType() {
        return this.session.getActivePlayerType();
    }

    public boolean isWinner() {
        return this.session.isWinner();
    }

    public int getActiveMachineColumn() {
        return this.session.getActiveMachineColumn();
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

    public StageValue getStageValue() {
        return this.session.getValueStage();
    }

    public void registry() {
        this.session.registry();
    }

    public boolean isUndoable() {
        return this.playerActionsController.isUndoable();
    }

    public boolean isRedoable() {
        return this.playerActionsController.isRedoable();
    }

    public void undo() {
        this.playerActionsController.undo();
    }

    public void redo() {
        this.playerActionsController.redo();
    }

    public void saveAndExit() {
        this.playerActionsController.saveAndExit();
    }

    public void dropToken(int column) {
        this.playerActionsController.dropToken(column);
    }

    public void accept(ControllersVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
