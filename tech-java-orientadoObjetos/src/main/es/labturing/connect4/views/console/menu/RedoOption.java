package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.utils.views.menu.Option;

public class RedoOption extends Option {

    private UndoRedoController undoRedoController;

    public RedoOption(UndoRedoController undoRedoController) {
        super(MessageManager.getInstance().getMessage("REDO"));
        this.undoRedoController = undoRedoController;
    }

    @Override
    public void interact() {
        this.undoRedoController.redo();
    }

}
