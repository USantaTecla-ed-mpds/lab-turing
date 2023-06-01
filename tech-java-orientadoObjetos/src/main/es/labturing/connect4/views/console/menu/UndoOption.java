package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.utils.views.menu.Option;

public class UndoOption extends Option {

    private PlayController playController;

    public UndoOption(PlayController playController) {
        super(MessageManager.getInstance().getMessage("UNDO"));
        this.playController = playController;
    }

    @Override
    public void interact() {
        this.playController.undo();
    }

    @Override
    public boolean isActive(){
        return this.playController.isUndoable();
    }

}
