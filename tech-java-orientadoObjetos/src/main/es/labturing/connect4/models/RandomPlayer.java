package main.es.labturing.connect4.models;

import main.es.labturing.connect4.types.PlayerType;

public class RandomPlayer extends MachinePlayer {
    public RandomPlayer(Board board) {
        super(board);
        this.type = PlayerType.RANDOM;
    }

    public int getColumn() {
        int column;
        do {
            column = (int) Math.floor(Math.random() * Coordinate.NUMBER_COLUMNS);
        } while (this.isComplete(column));
        return column;
    }

}
