package main.es.pbover.connecta$.views;

import main.es.pbover.connecta$.models.HumanPlayer;
import main.es.pbover.connecta$.models.Message;
import main.es.pbover.utils.InIntervalDialog;
import main.es.pbover.connecta$.models.Coordinate;

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
            inIntervalDialog.read(Message.ASK_COLUMN_TO_DROP.toString());
            column = inIntervalDialog.getAnswer() - 1;
            valid = !this.getPlayer().isComplete(column);
            if (!valid) {
                MessageView.getInstance().writeln(Message.ERR_COMPLETED_COLUMN_TO_DROP);
            }
        } while (!valid);
        return column;
    }
}
