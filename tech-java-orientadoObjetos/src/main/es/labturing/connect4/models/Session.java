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

    public StageValue getValueStage() {
        return this.stage.getValueStage();
    }

    public boolean isUndoable() {
        return this.gameManager.isUndoable();
    }

    public boolean isRedoable() {
        return this.gameManager.isRedoable();
    }

    public void undo() {
        this.game.setState(this.gameManager.getUndoneState());
    }

    public void redo() {
        this.game.setState(this.gameManager.getRedoneState());
    }

    public void registry() {
        this.gameManager.registry(this.game);

    }

    public void load() {
        this.gameManager.load(this.game);
    }

    public void save() {
        this.gameManager.save();
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

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

}
