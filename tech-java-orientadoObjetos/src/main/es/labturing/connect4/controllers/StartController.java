package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Session;
import main.es.labturing.connect4.types.PlayerType;
import main.es.labturing.utils.framework.AcceptorController;
import main.es.labturing.utils.framework.ControllersVisitor;

public class StartController extends Controller implements AcceptorController {

    private LoadController loadController;

    public StartController(Session session) {
        super(session);
        this.loadController = new LoadController(session);
    }

    public void resetGameRegistry() {
        this.session.resetGameRegistry();
    }

    public void addPlayer(PlayerType playerType) {
        this.session.addPlayer(playerType);
    }

    public void resetPlayers() {
        this.session.resetPlayers();
    }

    public void resetPlayersIndex () {
        this.session.resetPlayersIndex();;
    }

    public int getNumberPlayers() {
        return this.session.getNumberPlayers();
    }

    public void nextStage() {
        this.session.nextStage();
    }

    public void load(){
        this.loadController.load();
    }

    public boolean isGamePersisted(){
        return this.session.isGamePersisted();
    }

    public void accept(ControllersVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
}
