package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Session;

public class PlayerActionsController extends Controller {

    private UndoController undoController;
    private RedoController redoController;

    PlayerActionsController(Session session) {
        super(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
    }

    public boolean isUndoable() {
        return this.undoController.isUndoable();
    }

    public boolean isRedoable() {
        return this.redoController.isRedoable();
    }

    public void undo() {
        this.undoController.undo();
    }

    public void redo() {
        this.redoController.redo();
    }

    public void dropToken(int column) {
        this.session.dropToken(column);
        this.session.registry();
    } 
}
