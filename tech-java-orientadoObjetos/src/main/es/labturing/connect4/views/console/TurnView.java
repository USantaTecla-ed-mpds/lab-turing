package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.views.console.menu.ConfigTurnMenu;

public class TurnView {

    private PlayerView activePlayerView;
    private PlayerViewPrototype playerViewPrototype;

    public TurnView() {
       // this.playerViewPrototype = new PlayerViewPrototype(this.playController, this.undoRedoController); //Pasar a startController
    }

    public void configTurn(StartController startController) {
        new ConfigTurnMenu(startController).interact();
        startController.resetGameManager();
    }

    public void play(PlayController playController) {
        this.activePlayerView = this.playerViewPrototype.createView(playController.getActivePlayerType());
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
