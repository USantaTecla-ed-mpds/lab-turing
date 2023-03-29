package connect4.views.menu.option;

import connect4.models.Turn;


public abstract class ConfigTurnOption extends TurnOption {

    protected Turn turn;

    public ConfigTurnOption(String title, Turn turn) {
        super(title, turn);
    }
}