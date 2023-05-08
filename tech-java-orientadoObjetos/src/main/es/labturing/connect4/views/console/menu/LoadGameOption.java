package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.views.console.GameView;
import main.es.labturing.connect4.views.console.MessageManager;

public class LoadGameOption extends GameOption{

    private UndoRedoController undoRedoController;

    public LoadGameOption(GameView gameView, UndoRedoController undoRedoController) {
        super(MessageManager.getInstance().getMessage("LOAD"),gameView);
        this.undoRedoController = undoRedoController;

    }

    @Override
    public void interact() {
        this.undoRedoController.load();
    }
    
}
