package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.views.console.HumanPlayerView;
import main.es.labturing.utils.views.menu.Menu;

public class PlayerActionsMenu extends Menu {
    private UndoRedoController undoRedoController;
    private PlayController playController;
    private HumanPlayerView playerView;

    public PlayerActionsMenu(UndoRedoController undoRedoController, HumanPlayerView playerView,
            PlayController playController) {
        super("Player Actions Menus(msg):");
        this.undoRedoController = undoRedoController;
        this.playController = playController;
        this.playerView = playerView;
    }

    @Override
    protected void addOptions() {
        // this.add(new SaveAndExitOption());
        this.add(new PlayOption(this.playController, this.playerView, this.undoRedoController));
        if (this.undoRedoController.isUndoable()) {
            this.add(new UndoOption(this.undoRedoController));
        }
        if (this.undoRedoController.isRedoable()) {
            this.add(new RedoOption(this.undoRedoController));
        }

    }
}
