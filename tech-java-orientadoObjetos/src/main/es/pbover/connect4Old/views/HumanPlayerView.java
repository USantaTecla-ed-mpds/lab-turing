package main.es.pbover.connect4Old.views;

import main.es.pbover.connect4Old.models.Coordinate;
import main.es.pbover.connect4Old.models.HumanPlayer;
import main.es.pbover.utils.ClosedIntervalDialog;

public class HumanPlayerView extends PlayerView{

    public HumanPlayerView(HumanPlayer player) {
        super(player);
    }

    public int getColumn() {
        int column;
        boolean valid;
        do {
            Message.TURN.write();
            new Message(new ColorView(this.getPlayer().getColor()).toString()).writeln();
            ClosedIntervalDialog closedIntervalDialog = new ClosedIntervalDialog(1,Coordinate.NUMBER_COLUMNS);
            closedIntervalDialog.read(Message.ENTER_COLUMN_TO_DROP.toString());
            column = closedIntervalDialog.getAnswer()-1;
            valid = !this.getPlayer().isComplete(column);
            if (!valid) {
                Message.COMPLETED_COLUMN.writeln();
            }
        } while (!valid);
        return column;
    }
}
