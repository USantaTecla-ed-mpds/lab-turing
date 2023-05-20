package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Session;

public class UndoController extends Controller{

    UndoController(Session session) {
        super(session);
    }

    public void undo() {
        this.session.undo();
    }

    public void registry() {
        this.session.registry();
    }

    public boolean isUndoable() {
        return this.session.isUndoable();
    }

    
    
}
