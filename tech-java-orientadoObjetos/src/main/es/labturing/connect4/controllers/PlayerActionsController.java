package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Session;

public class PlayerActionsController extends Controller{

    private UndoController undoController;
    private RedoController redoController;
    private SaveAndExitController saveAndExitController;
    private DropTokenController dropTokenController;

    PlayerActionsController(Session session) {
        super(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
        this.dropTokenController = new DropTokenController(session);
        this.saveAndExitController = new SaveAndExitController(session);
    }

    public boolean isUndoable(){
        return this.undoController.isUndoable();
    }

    public boolean isRedoable(){
        return this.redoController.isRedoable();
    }

    public void undo(){
        this.undoController.undo();
    }

    public void redo(){
        this.redoController.redo();
    }

    public void saveAndExit(){
        this.saveAndExitController.save();
    }   

    public void dropToken(int column){
        this.dropTokenController.dropToken(column);
    }
}
