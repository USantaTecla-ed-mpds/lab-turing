package main.es.pbover.connect4.views;

import main.es.pbover.connect4.models.Coordinate;
import main.es.pbover.connect4.models.HumanPlayer;
import main.es.pbover.utils.ClosedIntervalDialog;

public class HumanPlayerView extends PlayerView {

    public HumanPlayerView(HumanPlayer player) {
        super(player);
    }

    public int getColumn() {
        int column;
        boolean valid;
        do {
            super.showPlayerTurn();
            ClosedIntervalDialog closedIntervalDialog = new ClosedIntervalDialog(1, Coordinate.NUMBER_COLUMNS);
            closedIntervalDialog.read(MessageManager.getInstance().getMessage("ASK_COLUMN_TO_DROP").toString());
            column = closedIntervalDialog.getAnswer() - 1;
            valid = !this.getPlayer().isComplete(column);
            if (!valid) {
                MessageManager.getInstance().writeln("ERR_COMPLETED_COLUMN_TO_DROP");
            }
        } while (!valid);
        return column;
    }
}
