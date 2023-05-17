package main.es.labturing.connect4.models;

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

    public void undo() {
        this.gameManager.undo();
    }

    public void redo() {
        this.gameManager.redo();
    }

}
