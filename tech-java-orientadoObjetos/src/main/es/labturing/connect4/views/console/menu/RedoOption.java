package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.utils.views.menu.Option;

public class RedoOption extends Option {

    private UndoRedoController undoRedoController;

    public RedoOption(UndoRedoController undoRedoController) {
        super("Redo (msg)");
        this.undoRedoController = undoRedoController;
    }

    @Override
    public void interact() {
        this.undoRedoController.redo();
    }

}
