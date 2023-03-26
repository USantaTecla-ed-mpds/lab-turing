package main.es.pbover.connect4.views.menu;

//import main.es.pbover.connect4.models.Color;
import main.es.pbover.connect4.models.Turn;
import main.es.pbover.connect4.views.MessageManager;
import main.es.pbover.utils.menu.SequentialMenu;

public class ConfigTurnMenu extends SequentialMenu {

    private Turn turn;

    public ConfigTurnMenu(Turn turn) {
        super(MessageManager.getInstance().getFormatedMessage("CONFIG_TURN_MENU_TITLE", "#color"),
                turn.getNumberPlayers());
        // new ColorView(Color.get(this.counter)).toString();
        // Color.get(this.counter).name //Sin this.counter???
        this.turn = turn;
    }

    @Override
    protected void addOptions() {
        this.add(new CreateHumanPlayerOption(this.turn));
        this.add(new CreateRandomPlayerOption(this.turn));
        this.add(new CreateAIPlayerOption(this.turn));
    }

    public void interact() {
        super.interact();
        this.turn.reset();
    }

}
