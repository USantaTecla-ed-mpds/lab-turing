package main.es.pbover.connect4.models;

public class RandomPlayer {
    constructor(color, board) {
        super(color, board);
    }

    accept(visitor) {
        visitor.visitRandomPlayer(this);
    }

    getColumn() {
        let column;
        do {
            column = Math.floor(Math.random() * Coordinate.NUMBER_COLUMNS);
        } while (this.isComplete(column));
        return column;
    }
}
