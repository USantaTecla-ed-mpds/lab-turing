package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.models.Color;
import main.es.pbover.connect4.models.Language;
import main.es.pbover.connect4.models.MessageManager;
import main.es.pbover.connect4.models.Turn;
import main.es.pbover.utils.menu.SequentialMenu;

public class ConfigTurnMenu extends SequentialMenu{

    private Turn turn;

    public ConfigTurnMenu(Turn turn) {
        super(MessageManager.getInstance().getFormatedMessage("MENU_CONFIG_TURN", Color.RED.name()), turn.getNumberPlayers());
        
        this.turn = turn;
    }

    @Override
    protected void addOptions() {
        this.add(new CreateHumanPlayerOption(this.turn));
        this.add(new CreateRandomPlayerOption(this.turn));
        this.add(new CreateIAPlayerOption(this.turn));
    }

    @Override
    public void finalizeSequence() {
        this.turn.reset();
    }

    

}
