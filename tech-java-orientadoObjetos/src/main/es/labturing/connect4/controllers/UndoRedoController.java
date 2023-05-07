package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Game;
import main.es.labturing.connect4.models.GameManager;
import main.es.labturing.connect4.models.GameState;

public class UndoRedoController extends Controller {

    public UndoRedoController(Game game) {
        super(game);
    }

    public void undo(){
        GameState gameState = GameManager.getInstance().getUndoneState();
        this.game.getBoard().setState(gameState.getBoardState());
        this.game.getTurn().setState(gameState.getTurnState());
    }

    public void redo(){
        GameState gameState = GameManager.getInstance().getRedoneState();
        this.game.getBoard().setState(gameState.getBoardState());
        this.game.getTurn().setState(gameState.getTurnState());  
    }

    public boolean isUndoable(){
        return GameManager.getInstance().isUndoable();
    }

    public boolean isRedoable(){
        return GameManager.getInstance().isRedoable();
    }
    
}
