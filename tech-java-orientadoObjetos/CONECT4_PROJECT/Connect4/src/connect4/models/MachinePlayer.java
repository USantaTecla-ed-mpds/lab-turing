package connect4.models;

import java.io.IOException;

import connect4.utils.exceptions.MessageNotFoundException;

public abstract class MachinePlayer extends Player {
    public MachinePlayer(Board board) {
        super(board);
    }

    public abstract void accept(PlayerVisitor visitor) throws MessageNotFoundException, ClassNotFoundException, IOException;

    public abstract int getColumn();
}
