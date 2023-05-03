package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.models.GameManager;
import main.es.labturing.utils.views.menu.Option;

public class UndoOption extends Option{

    private UndoRedoController undoRedoController;

    public UndoOption(UndoRedoController undoRedoController) {
        super("Undo a fuego");
        this.undoRedoController = undoRedoController;
    }

    @Override
    public void interact() {
        this.undoRedoController.undo();
    }
    
}
