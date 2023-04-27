package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.views.console.menu.ConfigTurnMenu;

public class TurnView {
    private StartController startController;
    private PlayController playController;
    private PlayerView activePlayerView;
    private PlayerViewPrototype playerViewPrototype;

    public TurnView(StartController startController, PlayController playController) {
        this.startController = startController;
        this.playController = playController;
        this.playerViewPrototype = new PlayerViewPrototype(playController);
    }

    public void configTurn() {
        new ConfigTurnMenu(this.startController).interact();
    }

    public void play() {
        this.activePlayerView = this.playerViewPrototype.createView(this.playController.getActivePlayerType());
        this.activePlayerView.showPlayerColor();
        this.playController.play(this.activePlayerView.getColumn());
    }

    public void writeResult() {
        if (playController.isWinner()) {
            this.activePlayerView.showWinner();
        } else {
            MessageManager.getInstance().writeln("PLAYERS_TIED");
        }
    }
}
