package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Coordinate;
import main.es.labturing.connect4.models.Session;
import main.es.labturing.connect4.types.Color;

public abstract class Controller {

    protected Session session;

    Controller(Session session) {
        this.session = session;
    }

    public void nextStage() {
        this.session.nextStage();
    }

    public Color getColor(Coordinate coordinate) {
        return this.session.getColor(coordinate);
    }

}
