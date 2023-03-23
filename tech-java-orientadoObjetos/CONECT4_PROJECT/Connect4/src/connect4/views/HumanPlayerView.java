package connect4.views;

import connect4.models.Coordinate;
import connect4.models.HumanPlayer;
import connect4.utils.InIntervalDialog;
import connect4.utils.MessageManager;

public class HumanPlayerView extends PlayerView {

    public HumanPlayerView(HumanPlayer player) {
        super(player);
    }

    public int getColumn() {
        int column;
        boolean valid;
        do {
            super.showPlayerTurn();
            InIntervalDialog inIntervalDialog = new InIntervalDialog(1, Coordinate.NUMBER_COLUMNS);
            inIntervalDialog.read(MessageManager.getInstance().getMessage("ASK_COLUMN_TO_DROP"));
            column = inIntervalDialog.getAnswer() - 1;
            valid = !this.getPlayer().isComplete(column);
            if (!valid) {
                MessageManager.getInstance().writeln("ERR_COMPLETED_COLUMN_TO_DROP");
            }
        } while (!valid);
        return column;
    }
}
