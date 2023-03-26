package main.es.pbover.connect4.models;

public abstract class MachinePlayer extends Player {

    public MachinePlayer(Board board) {
        super(board);
    }

    public abstract void accept(PlayerVisitor visitor);

    public abstract int getColumn();

}
