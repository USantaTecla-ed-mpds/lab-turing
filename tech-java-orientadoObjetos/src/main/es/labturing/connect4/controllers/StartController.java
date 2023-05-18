package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Session;
import main.es.labturing.connect4.types.PlayerType;
import main.es.labturing.utils.framework.AcceptorController;
import main.es.labturing.utils.framework.ControllersVisitor;


public class StartController extends Controller implements AcceptorController {

    public StartController(Session session) {
        super(session);
    }

    public void resetGameManager() {
        this.session.resetGameManager();
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

    public void accept(ControllersVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void nextStage() {
    }

}
