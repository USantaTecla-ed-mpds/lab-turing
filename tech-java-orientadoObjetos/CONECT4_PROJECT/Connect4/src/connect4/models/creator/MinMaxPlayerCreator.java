package connect4.models.creator;

import connect4.models.Board;
import connect4.models.MinMaxPlayer;
import connect4.models.Player;

public class MinMaxPlayerCreator extends MachinePlayerCreator {
    public Player createPlayer(Board board) {
        return new MinMaxPlayer(board);
    }
}
