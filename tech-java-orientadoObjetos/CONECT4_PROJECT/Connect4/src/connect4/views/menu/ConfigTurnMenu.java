package connect4.views.menu;

import connect4.models.Color;
import connect4.models.Turn;
import connect4.models.exceptions.MessageNotFoundException;
import connect4.utils.Console;
import connect4.utils.MessageManager;
import connect4.utils.menu.SequentialMenu;

public class ConfigTurnMenu extends SequentialMenu {

    private Turn turn;

    public ConfigTurnMenu(Turn turn) {
        super(turn.getNumberPlayers());
        this.turn = turn;
    }

    @Override
    protected void addOptions() {
        this.add(new CreateHumanPlayerOption(this.turn));
        this.add(new CreateRandomPlayerOption(this.turn));
        this.add(new CreateIAPlayerOption(this.turn));
    }

    protected void showTitle() throws MessageNotFoundException {
        String colorKey = Color.get(this.counter).toString();
        String color = MessageManager.getInstance().getMessage(colorKey);
        String msg = MessageManager.getInstance().getFormatedMessage("CONFIG_TURN_MENU_TITLE", color);
        Console.getInstance().writeln(msg);
    }

    @Override
    public void finalizeSequence() {
        this.turn.reset();
    }

}
