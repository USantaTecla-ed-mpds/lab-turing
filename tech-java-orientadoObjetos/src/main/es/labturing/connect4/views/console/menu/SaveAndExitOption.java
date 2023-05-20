package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.utils.views.menu.Option;

public class SaveAndExitOption extends Option {

    private PlayController playController;

    public SaveAndExitOption(PlayController playController) {
        super(MessageManager.getInstance().getMessage("SAVE_AND_EXIT"));
        this.playController = playController;
    }

    public void interact() {
        this.playController.save();
        System.exit(0);
    }
    
}
