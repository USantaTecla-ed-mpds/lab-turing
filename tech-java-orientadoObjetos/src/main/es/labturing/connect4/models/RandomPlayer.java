package main.es.labturing.connect4.models;

public class RandomPlayer extends MachinePlayer {
    public RandomPlayer(Board board) {
        super(board);
    }

    public void accept(PlayerVisitor visitor) {
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
