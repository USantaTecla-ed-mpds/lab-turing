package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.views.console.menu.ConfigTurnMenu;
import main.es.labturing.connect4.views.console.menu.PlayerActionsMenu;

public class TurnView {
    private StartController startController;
    private PlayController playController;
    private UndoRedoController undoRedoController;
    private PlayerView activePlayerView;
    private PlayerViewPrototype playerViewPrototype;

    public TurnView(StartController startController, PlayController playController, UndoRedoController undoRedoController) {
        this.startController = startController;
        this.playController = playController;
        this.undoRedoController = undoRedoController;
        this.playerViewPrototype = new PlayerViewPrototype(playController);
    }

    public void configTurn() {
        new ConfigTurnMenu(this.startController).interact();
    }

    public void play() {
        this.activePlayerView = this.playerViewPrototype.createView(this.playController.getActivePlayerType());
        this.activePlayerView.showPlayerColor();
        new PlayerActionsMenu(this.undoRedoController, this.activePlayerView, this.playController).interact();
        //this.playController.play(this.activePlayerView.getColumn());
    }

    public void writeResult() {
        if (playController.isWinner()) {
            this.activePlayerView.showWinner();
        } else {
            MessageManager.getInstance().writeln("PLAYERS_TIED");
        }
    }
}
