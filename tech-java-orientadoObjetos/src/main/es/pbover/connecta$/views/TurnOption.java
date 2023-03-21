package main.es.pbover.connecta$.views;

import main.es.pbover.utils.menu.Option;
import main.es.pbover.connecta$.models.Turn;

public abstract class TurnOption extends Option{

    protected Turn turn;

    public TurnOption(String title, Turn turn) {
        super(title);
        this.turn = turn;
    }  
}