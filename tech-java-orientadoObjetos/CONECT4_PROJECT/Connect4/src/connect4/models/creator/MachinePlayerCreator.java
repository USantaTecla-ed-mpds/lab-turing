package connect4.models.creator;

import connect4.models.Board;
import connect4.models.Player;

public abstract class MachinePlayerCreator extends PlayerCreator {
    public abstract Player createPlayer(Board board);
}
