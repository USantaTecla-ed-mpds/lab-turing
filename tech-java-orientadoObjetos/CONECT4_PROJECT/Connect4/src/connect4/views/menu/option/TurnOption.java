package connect4.views.menu.option;

import connect4.models.Turn;
import connect4.utils.menu.Option;

public abstract class TurnOption extends Option {

    protected Turn turn;

    public TurnOption(String title, Turn turn) {
        super(title);
        this.turn = turn;
    }

}
