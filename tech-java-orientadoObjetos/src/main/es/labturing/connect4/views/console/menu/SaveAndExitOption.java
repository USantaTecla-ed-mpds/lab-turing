package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.utils.views.menu.Option;

public class SaveAndExitOption extends Option {

    private UndoRedoController undoRedoController;

    public SaveAndExitOption(UndoRedoController undoRedoController) {
        super(MessageManager.getInstance().getMessage("SAVE AND EXIT"));
        this.undoRedoController = undoRedoController;
    }

    public void interact() {
        //this.undoRedoController.saveAndExit();  //TODO: esto mejor en playController mejor cambiar UndoRedoController por PlayerActionsController
    }
    
}
