package main.es.labturing.connect4.views;

import main.es.labturing.connect4.models.Coordinate;
import main.es.labturing.connect4.models.Turn;
import main.es.labturing.utils.views.ClosedIntervalDialog;

public class HumanPlayerView extends PlayerView {

    public HumanPlayerView(Turn turn) {
        super(turn);
    }

    public int getColumn() {
        int column;
        boolean valid;
        do {
            ClosedIntervalDialog closedIntervalDialog = new ClosedIntervalDialog(1, Coordinate.NUMBER_COLUMNS);
            closedIntervalDialog.read("ASK_COLUMN_TO_DROP");
            column = closedIntervalDialog.getAnswer() - 1;
            valid = !this.turn.getActivePlayer().isComplete(column);
            if (!valid) {
                MessageManager.getInstance().writeln("ERR_COMPLETED_COLUMN_TO_DROP");
            }
        } while (!valid);
        return column;
    }
}
