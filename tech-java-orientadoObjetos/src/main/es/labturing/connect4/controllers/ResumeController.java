package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Game;

public class ResumeController extends Controller {

    public ResumeController(Game game) {
        super(game);
    }

    public void reset() {
        this.game.reset();
    }

}
