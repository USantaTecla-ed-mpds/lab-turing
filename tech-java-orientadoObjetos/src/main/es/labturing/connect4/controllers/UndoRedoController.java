package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Game;
import main.es.labturing.connect4.models.GameManager;
import main.es.labturing.connect4.models.GameState;

public class UndoRedoController extends Controller {

    private GameManager gameManager;

    public UndoRedoController(Game game) {
        super(game);
        this.gameManager = new GameManager(this.game);
    }

    public void undo() {
        GameState gameState = this.gameManager.getUndoneState();
        this.game.setState(gameState);
    }

    public void redo() {
        GameState gameState = this.gameManager.getRedoneState();
        this.game.setState(gameState);
    }

    public void registry() {
        this.gameManager.registry();
    }

    public boolean isUndoable() {
        return this.gameManager.isUndoable();
    }

    public boolean isRedoable() {
        return this.gameManager.isRedoable();
    }

}
