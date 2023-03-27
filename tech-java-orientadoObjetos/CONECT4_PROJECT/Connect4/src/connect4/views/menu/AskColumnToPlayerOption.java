package connect4.views.menu;

import connect4.models.Coordinate;
import connect4.models.Player;
import connect4.models.Turn;
import connect4.utils.ClosedInterval;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.MessageManager;
import connect4.views.dialog.SelectCurrentPlayDialog;

public class AskColumnToPlayerOption extends TurnOption {

    private Player player;
    private Turn turn;

    public AskColumnToPlayerOption(String title, Player player, Turn turn) throws MessageNotFoundException {
        super(title);
        this.player = player;
        this.turn = turn;
    }

    @Override
    public void interact() throws MessageNotFoundException {

        int column;
        boolean valid = false;

        do {
            ClosedInterval closedInterval = new ClosedInterval(1, Coordinate.NUMBER_COLUMNS);
            SelectCurrentPlayDialog selectCurrentPlayDialog = new SelectCurrentPlayDialog(closedInterval);
            selectCurrentPlayDialog.show(MessageManager.getInstance().getMessage("ASK_COLUMN_TO_DROP"));
            column = selectCurrentPlayDialog.getAnswer() - 1;
            valid = !this.player.isComplete(column);
            if (!valid) {
                MessageManager.getInstance().writeln("ERR_COMPLETED_COLUMN_TO_DROP");
            }
        } while (!valid);
        
        this.turn.play(column);

    }
}
