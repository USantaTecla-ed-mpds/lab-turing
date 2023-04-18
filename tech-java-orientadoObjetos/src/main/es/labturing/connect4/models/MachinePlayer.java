package main.es.labturing.connect4.models;

public abstract class MachinePlayer extends Player {

    public MachinePlayer(Board board) {
        super(board);
    }

    public abstract int getColumn();

}
