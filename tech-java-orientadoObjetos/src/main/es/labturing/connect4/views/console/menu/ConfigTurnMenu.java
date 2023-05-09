package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.types.Color;
import main.es.labturing.connect4.views.console.ColorView;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.utils.views.Console;
import main.es.labturing.utils.views.menu.SequentialMenu;

public class ConfigTurnMenu extends SequentialMenu {

    private StartController startController;

    public ConfigTurnMenu(StartController startController) {
        super("", startController.getNumberPlayers());
        this.startController = startController;
    }

    @Override
    protected void addOptions() {
        this.add(new CreateHumanPlayerOption(this.startController));
        this.add(new CreateRandomPlayerOption(this.startController));
        this.add(new CreateMinMaxPlayerOption(this.startController));
    }

    @Override
    protected void showTitle() {
        this.title = MessageManager.getInstance().getMessage("CONFIG_TURN_MENU_TITLE",
                new ColorView(Color.get(this.counter)).toString());
        super.showTitle();
    }

    @Override
    protected void execChoosedOption() {
        int answer;
        boolean ok;
        do {
            answer = Console.getInstance().readInt(
                    MessageManager.getInstance().getMessage("MENU_CHOOSE_OPTION_PREFIX") + this.options.size() + "]: ")
                    - 1;
            ok = 0 <= answer && answer <= this.options.size() - 1;
            if (!ok) {
                Console.getInstance().writeln("Error!!!");
            }
        } while (!ok);
        this.options.get(answer).interact();
    }

    public void interact() {
        this.startController.resetPlayers();
        super.interact();
    }

}
