package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.views.console.menu.ConfigTurnMenu;

public class TurnView {

    private PlayerView activePlayerView;

    public TurnView() {
    }

    public void configTurn(StartController startController) {
        new ConfigTurnMenu(startController).interact();
        startController.resetGameRegistry();
    }

    public void play(PlayController playController) {
        this.activePlayerView = playController.createPlayerView();
        this.activePlayerView.showPlayerColor();
        this.activePlayerView.play();
    }

    public void writeResult(PlayController playController) {
        if (playController.isWinner()) {
            this.activePlayerView.showWinner();
        } else {
            MessageManager.getInstance().writeln("PLAYERS_TIED");
        }
    }
}
