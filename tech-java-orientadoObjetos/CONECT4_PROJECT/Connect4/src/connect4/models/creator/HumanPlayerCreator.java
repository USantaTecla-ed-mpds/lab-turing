package connect4.models.creator;

import connect4.models.Board;
import connect4.models.HumanPlayer;
import connect4.models.Player;

public class HumanPlayerCreator extends PlayerCreator {
    public Player createPlayer(Board board) {
        return new HumanPlayer(board);
    }
}
