package main.es.labturing.connect4.views.menu;

import main.es.labturing.connect4.models.Turn;
import main.es.labturing.utils.views.menu.Option;

public abstract class ConfigTurnOption extends Option{

    protected Turn turn;

    public ConfigTurnOption(String title, Turn turn) {
        super(title);
        this.turn = turn;
    }  
}