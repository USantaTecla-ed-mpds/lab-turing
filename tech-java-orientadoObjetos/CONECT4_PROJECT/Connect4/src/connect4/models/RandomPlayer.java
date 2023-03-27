package connect4.models;

import java.io.IOException;

import connect4.utils.exceptions.MessageNotFoundException;

public class RandomPlayer extends MachinePlayer {
    public RandomPlayer(Board board) {
        super(board);
    }

    public void accept(PlayerVisitor visitor) throws MessageNotFoundException, ClassNotFoundException, IOException {
        visitor.visit(this);
    }

    public int getColumn() {
        int column;
        do {
            column = (int) Math.floor(Math.random() * Coordinate.NUMBER_COLUMNS);
        } while (this.isComplete(column));
        return column;
    }

}
