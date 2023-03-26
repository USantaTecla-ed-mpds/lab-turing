package connect4.views;

import connect4.models.Coordinate;
import connect4.models.HumanPlayer;
import connect4.utils.ClosedInterval;
import connect4.utils.SelectNextPlayDialog;
import connect4.utils.MessageManager;
import connect4.utils.exceptions.MessageNotFoundException;

public class HumanPlayerView extends PlayerView {

    public HumanPlayerView(HumanPlayer player) {
        super(player);
    }

    public int getColumn() throws MessageNotFoundException {

        int column;
        boolean valid = false;
        do {
            super.showPlayerTurn();

            ClosedInterval closedInterval = new ClosedInterval(1, Coordinate.NUMBER_COLUMNS);
            SelectNextPlayDialog selectNextPlayDialog = new SelectNextPlayDialog(closedInterval, 'g');
            selectNextPlayDialog.show(MessageManager.getInstance().getMessage("ASK_COLUMN_TO_DROP"));

            if (Character.isDigit(selectNextPlayDialog.getAnswer())) {
                column = Character.getNumericValue(selectNextPlayDialog.getAnswer()) - 1;
                valid = !this.getPlayer().isComplete(column);
                if (!valid) {
                    MessageManager.getInstance().writeln("ERR_COMPLETED_COLUMN_TO_DROP");
                }
            } else {
                valid = true;
                column = -1;
            }

        } while (!valid);
        return column;
    }
}
