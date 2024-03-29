package main.es.labturing.connect4.models;

import main.es.labturing.connect4.types.Color;
import main.es.labturing.connect4.types.PlayerType;
import main.es.labturing.connect4.types.StageValue;

public class Session {

    private Stage stage;
    private Game game;
    private Registry registry;
    private String name;

    public Session() {
        this.stage = new Stage();
        this.game = new Game();
        this.registry = new Registry(this.game);
    }

    public void reset() {
        this.game.reset();
        this.stage.reset();
        this.resetRegistry();
    }

    public void resetRegistry() {
        this.registry.reset();
    }

    public void registry() {
        this.registry.registry(this.game);
    }

    public void nextStage() {
        this.stage.next();
    }

    public StageValue getValueStage() {
        return this.stage.getValueStage();
    }

    public void setStageValue(StageValue stageValue) {
        this.stage.setStageValue(stageValue);
    }

    public boolean isUndoable() {
        return this.registry.isUndoable();
    }

    public boolean isRedoable() {
        return this.registry.isRedoable();
    }

    public void undo() {
        this.game.setState(this.registry.getUndoneState());
    }

    public void redo() {
        this.game.setState(this.registry.getRedoneState());
    }

    public void addPlayer(PlayerType playerType) {
        this.game.addPlayer(playerType);
    }

    public void resetPlayers() {
        this.game.resetPlayers();
    }

    public void resetPlayersIndex() {
        this.game.resetPlayersIndex();
    }

    public int getNumberPlayers() {
        return this.game.getNumberPlayers();
    }

    public void dropToken(int column) {
        this.game.dropToken(column);
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

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

    public GameState getState() {
        return this.game.getState();
    }

    public void setState(GameState gameState) {
        this.game.setState(gameState);
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean hasName() {
        return this.name != null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
