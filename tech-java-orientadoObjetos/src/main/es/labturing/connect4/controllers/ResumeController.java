package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Session;
import main.es.labturing.utils.framework.AcceptorController;
import main.es.labturing.utils.framework.ControllersVisitor;

public class ResumeController extends Controller implements AcceptorController {

    public ResumeController(Session session) {
        super(session);
    }

    public void reset() {
        this.session.reset();
    }

    public void accept(ControllersVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void nextStage() {
    }

}
