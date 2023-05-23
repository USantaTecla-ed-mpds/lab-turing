package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.PlayController;

public abstract class PlayerView {
    
    public PlayerView() {
    }

    protected void showWinner(PlayController playController) {
        MessageManager.getInstance().writeln("PLAYER_WIN",
                new ColorView(playController.getActivePlayerColor()).toString());
    }

    protected void showPlayerColor(PlayController playController) {
        MessageManager.getInstance().writeln("TURN", new ColorView(playController.getActivePlayerColor()).toString());
    }

    public abstract void play(PlayController playController);

}
