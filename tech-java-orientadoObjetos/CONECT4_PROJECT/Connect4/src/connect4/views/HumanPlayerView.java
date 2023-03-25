package connect4.views;

import connect4.models.Coordinate;
import connect4.models.HumanPlayer;
import connect4.utils.ClosedIntervalDialog;
import connect4.utils.MessageManager;
import connect4.utils.exceptions.MessageNotFoundException;

public class HumanPlayerView extends PlayerView {

    public HumanPlayerView(HumanPlayer player) {
        super(player);
    }

    public int getColumn() throws MessageNotFoundException {

        int column;
        boolean valid;
        do {
            super.showPlayerTurn();
            ClosedIntervalDialog closedIntervalDialog = new ClosedIntervalDialog(1, Coordinate.NUMBER_COLUMNS);
            closedIntervalDialog.show(MessageManager.getInstance().getMessage("ASK_COLUMN_TO_DROP"));
            column = closedIntervalDialog.getAnswer() - 1;
            valid = !this.getPlayer().isComplete(column);
            if (!valid) {
                MessageManager.getInstance().writeln("ERR_COMPLETED_COLUMN_TO_DROP");
            }
        } while (!valid);
        return column;
    }
}
