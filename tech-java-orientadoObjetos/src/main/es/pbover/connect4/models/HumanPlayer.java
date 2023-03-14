package main.es.pbover.connect4.models;

public class HumanPlayer {
    constructor(color, board) {
        super(color, board);
    }
    accept(visitor) {
        visitor.visitHumanPlayer(this);
    }

}
