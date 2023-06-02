package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Coordinate;
import main.es.labturing.connect4.models.Session;
import main.es.labturing.connect4.types.Color;
import main.es.labturing.connect4.types.StageValue;

public abstract class Controller {

    protected Session session;

    Controller(Session session) {
        this.session = session;
    }

    public void nextStage() {
        this.session.nextStage();
    }

    public void setStageValue(StageValue stageValue) {
        this.session.setStageValue(stageValue);
    }

    public Color getColor(Coordinate coordinate) {
        return this.session.getColor(coordinate);
    }

}
