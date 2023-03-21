package main.es.pbover.connecta$.views.menu;

import main.es.pbover.connecta$.models.Turn;

import main.es.pbover.utils.menu.Menu;

public abstract class TurnMenu extends Menu{

    protected Turn turn;

    public TurnMenu(String title, Turn turn) {
        super(title);
        this.turn = turn;
    } 
}
