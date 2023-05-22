package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.GameState;
import main.es.labturing.connect4.models.Session;
import main.es.labturing.connect4.types.Color;
import main.es.labturing.connect4.views.console.PlayerView;
import main.es.labturing.connect4.views.console.PlayerViewPrototype;
import main.es.labturing.utils.framework.AcceptorController;
import main.es.labturing.utils.framework.ControllersVisitor;

public class PlayController extends Controller implements AcceptorController {

    private InGameActionsController inGameActionsController;
    private PlayerViewPrototype playerViewPrototype;

    public PlayController(Session session) {
        super(session);
        this.inGameActionsController = new InGameActionsController(session);
        this.playerViewPrototype = new PlayerViewPrototype(this);
    }

    public void dropToken(int column) {
        this.inGameActionsController.dropToken(column);
    }

    public boolean isWinner() {
        return this.session.isWinner();
    }

    public int getActiveMachineColumn() {
        return this.session.getActiveMachineColumn();
    }

    public PlayerView createPlayerView(){
        return playerViewPrototype.createView(this.session.getActivePlayerType());
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

    public void nextStage() {
        this.session.nextStage();
    }

    public void registry(){
        this.session.registry();
    }

    public boolean isUndoable(){
        return this.inGameActionsController.isUndoable();
    }

    public boolean isRedoable(){
        return this.inGameActionsController.isRedoable();
    }

    public void undo(){
        this.inGameActionsController.undo();
    }

    public void redo(){
        this.inGameActionsController.redo();
    }

    public void saveAndExit(){
        this.inGameActionsController.saveAndExit();
    }

    public void accept(ControllersVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
}
