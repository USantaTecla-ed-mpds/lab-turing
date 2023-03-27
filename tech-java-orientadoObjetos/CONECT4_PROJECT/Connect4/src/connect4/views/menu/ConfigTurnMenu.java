package connect4.views.menu;

import java.io.IOException;

import connect4.models.Color;
import connect4.models.Turn;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.utils.menu.SequentialMenu;
import connect4.views.MessageManager;

public class ConfigTurnMenu extends SequentialMenu {

    private Turn turn;

    public ConfigTurnMenu(Turn turn) {
        super(turn.getNumberPlayers());
        this.turn = turn;
    }

    @Override
    protected void addOptions() throws MessageNotFoundException {
        this.add(new CreateHumanPlayerOption(this.turn));
        this.add(new CreateRandomPlayerOption(this.turn));
        this.add(new CreateIAPlayerOption(this.turn));
    }

    @Override
    protected void showTitle() throws MessageNotFoundException {
        this.title = MessageManager.getInstance().getMessage("CONFIG_TURN_MENU_TITLE",
                Color.get(this.counter).getString());
        super.showTitle();
    }

    @Override
    public void interact() throws MessageNotFoundException, ClassNotFoundException, IOException {
        super.interact();
        this.turn.reset();
    }

}
