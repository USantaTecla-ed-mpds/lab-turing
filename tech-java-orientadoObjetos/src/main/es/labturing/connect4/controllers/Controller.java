package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Game;

public abstract class Controller {

    protected Game game;

    Controller(Game game) {
        this.game = game;
    }
    
}
