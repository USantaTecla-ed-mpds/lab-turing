package main.es.labturing.connect4.models;

import main.es.labturing.connect4.types.Color;
import main.es.labturing.connect4.types.PlayerType;

public class Session {

    private Stage stage;
    private Game game;
    private GameRegistry gameRegistry;
    private GamePersister gamePersister;

    public Session() {
        this.stage = new Stage();
        this.game = new Game();
        this.gameRegistry = new GameRegistry(game);
        this.gamePersister = new GamePersister(game);
    }

    public void reset() {
        this.game.reset();
        this.stage.reset();
        this.resetGameRegistry();
    }

    public void resetGameRegistry() {
        this.gameRegistry.reset();
    }

    public void nextStage() {
        this.stage.next();
    }

    public StageValue getValueStage() {
        return this.stage.getValueStage();
    }

    public boolean isUndoable() {
        return this.gameRegistry.isUndoable();
    }

    public boolean isRedoable() {
        return this.gameRegistry.isRedoable();
    }

    public void undo() {
        this.game.setState(this.gameRegistry.getUndoneState());
    }

    public void redo() {
        this.game.setState(this.gameRegistry.getRedoneState());
    }

    public void registry() {
        this.gameRegistry.registry(this.game);

    }

    public void load() {
        this.gamePersister.load();
    }

    public void save() {
        this.gamePersister.save(this.gameRegistry.getLastGameState());
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
