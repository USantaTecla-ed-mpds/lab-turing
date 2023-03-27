package connect4.views;

import java.io.IOException;

import connect4.models.HumanPlayer;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.menu.TurnMenu;

public class HumanPlayerView extends PlayerView {

    public HumanPlayerView(HumanPlayer player) {
        super(player);
    }

    public int getColumn() throws MessageNotFoundException, ClassNotFoundException, IOException {

        TurnMenu turnMenu = new TurnMenu(MessageManager.getInstance().getMessage("TURN_MENU",
                this.getPlayer().getColor().getString()));

        turnMenu.interact();

        int column = 1;
        /*
         * boolean valid = false;
         * do {
         * super.showPlayerTurn();
         * ClosedInterval closedInterval = new ClosedInterval(1,
         * Coordinate.NUMBER_COLUMNS);
         * SelectCurrentPlayDialog selectCurrentPlayDialog = new
         * SelectCurrentPlayDialog(closedInterval);
         * selectCurrentPlayDialog.show(MessageManager.getInstance().getMessage(
         * "ASK_COLUMN_TO_DROP"));
         * column = selectCurrentPlayDialog.getAnswer() - 1;
         * valid = !this.getPlayer().isComplete(column);
         * if (!valid) {
         * MessageManager.getInstance().writeln("ERR_COMPLETED_COLUMN_TO_DROP");
         * }
         * } while (!valid);
         */

        return column;
    }
}
