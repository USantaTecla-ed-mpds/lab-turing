package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.views.console.PlayerView;
import main.es.labturing.utils.views.menu.Option;

public class PlayOption extends Option{

    private PlayController playController;
    private PlayerView playerView;

    public PlayOption(PlayController playController, PlayerView playerView) {
        super("Drop a fuego");
        this.playController = playController;
        this.playerView = playerView;
    }

    @Override
    public void interact() {
        this.playController.play(this.playerView.getColumn());
        this.playController.registry(this.playController.getState());
    }
    
}
