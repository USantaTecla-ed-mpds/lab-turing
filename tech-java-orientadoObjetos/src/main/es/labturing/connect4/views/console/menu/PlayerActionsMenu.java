package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.RedoController;
import main.es.labturing.connect4.views.console.HumanPlayerView;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.utils.views.menu.Menu;

public class PlayerActionsMenu extends Menu {
    private PlayController playController;
    private HumanPlayerView playerView;

    public PlayerActionsMenu(HumanPlayerView playerView, PlayController playController) {
        super(MessageManager.getInstance().getMessage("PLAYER_ACTIONS_TITLE"));
        this.playController = playController;
        this.playerView = playerView;
    }

    @Override
    protected void addOptions() {
        // this.add(new SaveAndExitOption());
        this.add(new PlayOption(this.playController, this.playerView));
        if (this.playController.isUndoable()) {
            this.add(new UndoOption(this.playController));
        }
        if (this.playController.isRedoable()) {
            this.add(new RedoOption(this.playController));
        }

    }
}
