package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Session;

public class RedoController extends Controller {

    public RedoController(Session session) {
        super(session);
    }

    public void redo() {
        this.session.redo();
    }

    public void registry() {
        this.session.registry();
    }

    public boolean isRedoable() {
        return this.session.isRedoable();
    }

}
