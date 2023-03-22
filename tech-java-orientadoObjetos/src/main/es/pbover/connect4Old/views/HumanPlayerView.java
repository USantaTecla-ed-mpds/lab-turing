package main.es.pbover.connect4Old.views;

import main.es.pbover.connect4Old.models.Coordinate;
import main.es.pbover.connect4Old.models.HumanPlayer;
import main.es.pbover.utils.InIntervalDialog;

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
            InIntervalDialog inIntervalDialog = new InIntervalDialog(1,Coordinate.NUMBER_COLUMNS);
            inIntervalDialog.read(Message.ENTER_COLUMN_TO_DROP.toString());
            column = inIntervalDialog.getAnswer()-1;
            valid = !this.getPlayer().isComplete(column);
            if (!valid) {
                Message.COMPLETED_COLUMN.writeln();
            }
        } while (!valid);
        return column;
    }
}
