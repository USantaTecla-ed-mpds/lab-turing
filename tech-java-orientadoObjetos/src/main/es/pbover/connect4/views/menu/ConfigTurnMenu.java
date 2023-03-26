package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.models.Color;
import main.es.pbover.connect4.models.Turn;
import main.es.pbover.connect4.views.MessageManager;
import main.es.pbover.utils.menu.SequentialMenu;

public class ConfigTurnMenu extends SequentialMenu {

    private Turn turn;

    public ConfigTurnMenu(Turn turn) {
        super("", turn.getNumberPlayers());
        this.turn = turn;
    }

    @Override
    protected void addOptions() {
        this.add(new CreateHumanPlayerOption(this.turn));
        this.add(new CreateRandomPlayerOption(this.turn));
        this.add(new CreateAIPlayerOption(this.turn));
    }

    @Override
    protected void showTitle() {
        this.title = MessageManager.getInstance().getMessage("CONFIG_TURN_MENU_TITLE",Color.get(this.counter).getString());
        super.showTitle();
    }

    public void interact() {
        super.interact();
        this.turn.reset();
    }

}
