package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.PlayController;

public abstract class PlayerView {
    protected PlayController playController;

    public PlayerView(PlayController playController) {
        this.playController = playController;
    }

    protected void showWinner() {
        MessageManager.getInstance().writeln("PLAYER_WIN",
                new ColorView(this.playController.getActivePlayerColor()).toString());
    }

    protected void showPlayerColor() {
        MessageManager.getInstance().writeln("TURN", new ColorView(this.playController.getActivePlayerColor()).toString());
    }

    public abstract void dropToken();

}
