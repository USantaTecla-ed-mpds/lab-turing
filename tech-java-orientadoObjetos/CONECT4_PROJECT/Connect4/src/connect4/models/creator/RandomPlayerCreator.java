package connect4.models.creator;

import connect4.models.Board;
import connect4.models.Player;
import connect4.models.RandomPlayer;

public class RandomPlayerCreator extends MachinePlayerCreator {
    public Player createPlayer(Board board) {
        return new RandomPlayer(board);
    }
}
