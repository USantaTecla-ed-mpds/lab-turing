package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.utils.views.menu.Option;

public class RedoOption extends Option {

    private PlayController playController;

    public RedoOption(PlayController playController) {
        super(MessageManager.getInstance().getMessage("REDO"));
        this.playController = playController;
    }

    @Override
    public void interact() {
        this.playController.redo();
    }

}
