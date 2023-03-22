package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.models.Turn;
import main.es.pbover.utils.menu.Option;

public abstract class ConfigTurnOption extends Option{

    protected Turn turn;

    public ConfigTurnOption(String title, Turn turn) {
        super(title);
        this.turn = turn;
    }  
}