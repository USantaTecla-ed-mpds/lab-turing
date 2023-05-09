package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Game;
import main.es.labturing.connect4.models.GameManager;

public class UndoRedoController extends Controller {

    private GameManager gameManager;

    public UndoRedoController(Game game) {
        super(game);
        
    }

    public void createGameManager() {
        this.gameManager = new GameManager(this.game);
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

    public boolean isUndoable() {
        return this.gameManager.isUndoable();
    }

    public boolean isRedoable() {
        return this.gameManager.isRedoable();
    }

    public void load() {
        this.gameManager.load(this.game);
    }

    public void save() {
        this.gameManager.save();
    }

}
