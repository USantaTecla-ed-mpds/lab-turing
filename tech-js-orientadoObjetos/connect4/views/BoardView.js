import { Board, Coordinate } from '../utils/Board.js';
import { Message } from './Message.js';
import { console } from '../utils/console.js';

class ColorView {
    #color;

    constructor(color) {
        this.#color = color;
    }
    write() {
        console.write(` ${this.#color.getString()[0]} `);
    }
    toString() {
        return this.#color.getString();
    }

}

class BoardView {
    static BLANK_SPACES = 4;
    #board;

    constructor(board) {
        this.#board = board;
    }
    writeln() {
        this.#writeHorizontal();
        for (let i = Coordinate.NUMBER_ROWS - 1; i >= 0; i--) {
            Message.VERTICAL_LINE.write();
            for (let j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                new ColorView(this.#board.getColor(new Coordinate(i, j))).write();
                Message.VERTICAL_LINE.write();
            }
            new Message().writeln();
        }
        this.#writeHorizontal();
    }

    #writeHorizontal() {

        for (let i = 0; i < BoardView.BLANK_SPACES * Coordinate.NUMBER_COLUMNS; i++) {
            Message.HORIZONTAL_LINE.write();
        }
        Message.HORIZONTAL_LINE.writeln();
    }

}

export { Board, BoardView, ColorView };