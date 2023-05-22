package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.views.console.HumanPlayerView;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.utils.views.menu.Option;

public class DropOption extends Option {

    private PlayController playController;
    private HumanPlayerView playerView;

    public DropOption(PlayController playController, HumanPlayerView playerView) {
        super(MessageManager.getInstance().getMessage("DROP"));
        this.playController = playController;
        this.playerView = playerView;
    }

    @Override
    public void interact() {
        this.playController.dropToken(this.playerView.getColumn());
    }
}
