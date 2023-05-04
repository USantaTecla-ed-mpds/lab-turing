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

    public void undo(){
        GameState gameState = gameManager.getUndoneState();
        this.game.setState(gameState);
    }

    public void redo(){
        GameState gameState = gameManager.getRedoneState();
        this.game.setState(gameState);
    }
    
}
