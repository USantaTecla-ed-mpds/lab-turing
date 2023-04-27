package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.utils.views.menu.Option;

public abstract class ConfigTurnOption extends Option {

    protected StartController startController;

    public ConfigTurnOption(String title, StartController startController) {
        super(title);
        this.startController = startController;
    }
}