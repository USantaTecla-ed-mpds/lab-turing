import { Coordinate } from '../models/Board.js';
import { Message } from './Message.js';
class ColorView {
    #color;

    constructor(color) {
        this.#color = color;
    }
    write() {
        new Message(` ${this.#color.getString()[0]} `).write(); //Set background-color
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
            Message.VERTICAL_LINE.write(); //CSS
            for (let j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                new ColorView(this.#board.getColor(new Coordinate(i, j))).write(); //HTML le pasa el elmemento al que le tiene que poner el fondo de color
                Message.VERTICAL_LINE.write(); //CSS
            }
            new Message().writeln(); //CSS
        }
        this.#writeHorizontal(); //CSS
    }

    #writeHorizontal() {

        for (let i = 0; i < BoardView.BLANK_SPACES * Coordinate.NUMBER_COLUMNS; i++) {
            Message.HORIZONTAL_LINE.write(); //CSS
        }
        Message.HORIZONTAL_LINE.writeln(); //CSS
    }

}

export { BoardView, ColorView };