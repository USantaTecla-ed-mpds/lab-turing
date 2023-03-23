package connect4.views.menu;

import connect4.models.Turn;
import connect4.utils.menu.Option;

public abstract class ConfigTurnOption extends Option {

    protected Turn turn;

    public ConfigTurnOption(String title, Turn turn) {
        super(title);
        this.turn = turn;
    }
}