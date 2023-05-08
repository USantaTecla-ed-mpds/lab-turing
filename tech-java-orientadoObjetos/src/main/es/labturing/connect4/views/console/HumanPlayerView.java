package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.models.Coordinate;
import main.es.labturing.connect4.views.console.menu.PlayerActionsMenu;
import main.es.labturing.utils.views.ClosedIntervalDialog;

public class HumanPlayerView extends PlayerView {

    private UndoRedoController undoRedoController;

    public HumanPlayerView(PlayController playController, UndoRedoController undoRedoController) {
        super(playController);
        this.undoRedoController = undoRedoController;
    }

    public void play() {
        new PlayerActionsMenu(this.undoRedoController, this, this.playController).interact();
    }

    public int getColumn() {
        int column;
        boolean valid;
        do {
            ClosedIntervalDialog closedIntervalDialog = new ClosedIntervalDialog(1, Coordinate.NUMBER_COLUMNS);
            closedIntervalDialog.read("ASK_COLUMN_TO_DROP");
            column = closedIntervalDialog.getAnswer() - 1;
            valid = !this.playController.isActivePlayerComplete(column);
            if (!valid) {
                MessageManager.getInstance().writeln("ERR_COMPLETED_COLUMN_TO_DROP");
            }
        } while (!valid);
        return column;
    }
}
