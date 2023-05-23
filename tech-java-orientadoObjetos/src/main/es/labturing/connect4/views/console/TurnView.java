package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.views.console.menu.ConfigTurnMenu;

public class TurnView {

    private PlayerView activePlayerView;
    private PlayerViewPrototype playerViewPrototype;

    public TurnView() {
        this.playerViewPrototype = new PlayerViewPrototype();
    }

    public void configTurn(StartController startController) {
        new ConfigTurnMenu(startController).interact();
        startController.resetGameRegistry();
    }

    public void play(PlayController playController) {
        this.activePlayerView = playerViewPrototype.createView(playController.getActivePlayerType());
        this.activePlayerView.showPlayerColor(playController);
        this.activePlayerView.play(playController);
    }

    public void writeResult(PlayController playController) {
        if (playController.isWinner()) {
            this.activePlayerView.showWinner(playController);
        } else {
            MessageManager.getInstance().writeln("PLAYERS_TIED");
        }
    }
}
