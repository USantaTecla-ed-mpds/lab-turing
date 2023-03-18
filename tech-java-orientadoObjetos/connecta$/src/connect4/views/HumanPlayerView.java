package connect4.views;

import connect4.utils.Console;
import connect4.utils.InIntervalDialog;
import connect4.models.Coordinate;
import connect4.models.HumanPlayer;
import connect4.models.Message;

public class HumanPlayerView extends PlayerView {

    public HumanPlayerView(HumanPlayer player) {
        super(player);
    }

    public int getColumn() {
        int column;
        boolean valid;
        do {
            Message.TURN.writelnFormated(this.getPlayer().getColor().getString());
            InIntervalDialog inIntervalDialog = new InIntervalDialog(1, Coordinate.NUMBER_COLUMNS);
            inIntervalDialog.read(Message.ENTER_COLUMN_TO_DROP.toString());
            column = inIntervalDialog.getAnswer() - 1;
            valid = !this.getPlayer().isComplete(column);
            if (!valid) {
                Message.COMPLETED_COLUMN.writeln();
            }
        } while (!valid);
        return column;
    }
}
