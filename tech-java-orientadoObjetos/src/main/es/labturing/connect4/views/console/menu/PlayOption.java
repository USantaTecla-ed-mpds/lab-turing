package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.views.console.PlayerView;
import main.es.labturing.utils.views.menu.Option;

public class PlayOption extends Option {

    private PlayController playController;
    private PlayerView playerView;
    private UndoRedoController undoRedoController;

    public PlayOption(PlayController playController, PlayerView playerView, UndoRedoController undoRedoController) {
        super("Drop (msg)");
        this.playController = playController;
        this.playerView = playerView;
        this.undoRedoController = undoRedoController;
    }

    @Override
    public void interact() {
        this.playController.play(this.playerView.getColumn());
        this.undoRedoController.registry();
    }

}
