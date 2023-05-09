package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.views.console.HumanPlayerView;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.utils.views.menu.Option;

public class PlayOption extends Option {

    private PlayController playController;
    private HumanPlayerView playerView;
    private UndoRedoController undoRedoController;

    public PlayOption(PlayController playController, HumanPlayerView playerView, UndoRedoController undoRedoController) {
        super(MessageManager.getInstance().getMessage("DROP"));
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
