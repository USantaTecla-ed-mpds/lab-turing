package main.es.labturing.connect4.models;

import main.es.labturing.connect4.types.PlayerType;

public abstract class MachinePlayer extends Player {

    public MachinePlayer(Board board) {
        super(board);
        this.type = PlayerType.RANDOM;
    }

    public abstract int getColumn();

}
