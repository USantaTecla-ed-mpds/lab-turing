package main.es.pbover.connect4.models;

public class Player {
    #color;
    #board;

    constructor(color, board) {
        this.#color = color;
        this.#board = board;
    }
    play(column) {
        this.#board.dropToken(column, this.#color);
    }
    getColor() {
        return this.#color;
    }
    isComplete(column) {
        return this.#board.isComplete(column);
    }
    
    getBoard() {
      return this.#board;
    }
    accept(visitor) { }
}
