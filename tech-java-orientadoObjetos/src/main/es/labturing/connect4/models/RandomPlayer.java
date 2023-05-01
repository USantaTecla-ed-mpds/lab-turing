package main.es.labturing.connect4.models;

import main.es.labturing.connect4.types.PlayerType;

public class RandomPlayer extends MachinePlayer {
    public RandomPlayer(Board board) {
        super(board);
    }

    public int getColumn() {
        int column;
        do {
            column = (int) Math.floor(Math.random() * Coordinate.NUMBER_COLUMNS);
        } while (this.isComplete(column));
        return column;
    }

    public MinMaxPlayer clone() {
        MinMaxPlayer clone = new MinMaxPlayer(this.board);
        clone.setColor(this.getColor());
        return clone;
    }

    public PlayerType getType() {
        return PlayerType.RANDOM;
    }

}
