package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Session;

public class InGameOptionsController extends Controller{

    private UndoController undoController;
    private RedoController redoController;
    private SaveController saveController;
    private LoadController loadController;

    InGameOptionsController(Session session) {
        super(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
        this.saveController = new SaveController(session);
        this.loadController = new LoadController(session);
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

    public void load(){
        this.loadController.load();
    }

    public void save(){
        this.saveController.save();
    }   
}
