package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Session;

public class UndoRedoController extends Controller {

    public UndoRedoController(Session session) {
        super(session);

    }

    public void undo() {
        this.session.undo();
    }

    public void redo() {
        this.session.redo();
    }

    public void registry() {
        this.session.registry();

    }

    public boolean isUndoable() {
        return this.session.isUndoable();
    }

    public boolean isRedoable() {
        return this.session.isRedoable();
    }

    public void load() {
        this.session.load();
    }

    public void save() {
        this.session.save();
    }

}
