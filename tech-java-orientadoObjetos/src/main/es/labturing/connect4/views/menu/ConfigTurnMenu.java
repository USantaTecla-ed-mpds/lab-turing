package main.es.labturing.connect4.views.menu;

import main.es.labturing.connect4.models.Color;
import main.es.labturing.connect4.models.Turn;
import main.es.labturing.connect4.views.ColorView;
import main.es.labturing.connect4.views.MessageManager;
import main.es.labturing.utils.views.Console;
import main.es.labturing.utils.views.menu.SequentialMenu;

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
        this.title = MessageManager.getInstance().getMessage("CONFIG_TURN_MENU_TITLE",new ColorView(Color.get(this.counter)).toString());
        super.showTitle();
    }
    
    @Override
    protected void execChoosedOption() {
        int answer;
        boolean ok;
        do {
            answer = Console.getInstance().readInt(MessageManager.getInstance().getMessage("MENU_CHOOSE_OPTION_PREFIX") + this.options.size() + "]: ") - 1;
            ok = 0 <= answer && answer <= this.options.size() - 1;
            if (!ok) {
                Console.getInstance().writeln("Error!!!");
            }
        } while (!ok);
        this.options.get(answer).interact();
    }

    public void interact() {
        super.interact();
        this.turn.reset();
    }

}
