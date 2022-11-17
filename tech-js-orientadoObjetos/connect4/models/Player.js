import { Coordinate } from './Board.js';

class Player {

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
    accept(visitor) { }
}

class HumanPlayer extends Player {

    constructor(color, board) {
        super(color, board);
    }
    accept(visitor) {
        visitor.visitHumanPlayer(this);
    }

}

class RandomPlayer extends Player {

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

class PlayerVisitor {

    visitHumanPlayer(humanPlayer) {
    }
    visitRandomPlayer(randomPlayer) {
    }

}

export { HumanPlayer, RandomPlayer , PlayerVisitor };