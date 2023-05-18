package main.es.labturing.connect4.models;

import main.es.labturing.connect4.types.Color;
import main.es.labturing.connect4.types.PlayerType;

public class Session {

    private Stage stage;
    private Game game;
    private GameManager gameManager;

    public Session() {
        this.stage = new Stage();
        this.game = new Game();
        this.gameManager = new GameManager(game);
    }

    public void reset() {
        this.game.reset();
        this.stage.reset();
        this.resetGameManager();
    }

    public void resetGameManager() {
        this.gameManager.reset();
    }

    public void nextStage() {
        this.stage.next();
    }

    public StageValue getValueState() {
        return this.stage.getValueStage();
    }

    public boolean undoable() {
        return this.gameManager.isUndoable();
    }

    public boolean redoable() {
        return this.gameManager.isRedoable();
    }

    public void addPlayer(PlayerType playerType) {
        this.game.addPlayer(playerType);
    }

    public void resetPlayers() {
        this.game.resetPlayers();
    }

    public void resetPlayersIndex() {
        this.game.resetPlayersIndex();
        ;
    }

    public int getNumberPlayers() {
        return this.game.getNumberPlayers();
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

}
