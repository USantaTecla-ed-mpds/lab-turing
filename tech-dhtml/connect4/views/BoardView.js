import { Coordinate } from '../models/Board.js';

class ColorView {
    #color;

    constructor(color) {
        this.#color = color;
    }
    write(element) {
        element.style.backgroundColor = this.#color.getString();
    }
    toString() {
        return this.#color.getString();
    }

}

class BoardView {
    #board;

    constructor(board) {
        this.#board = board;
    }
    writeln() {
        for (let element of document.getElementsByClassName("grid")) {
            element.remove();
        }
        let grid = document.createElement("div");

        grid.setAttribute("class", "grid");
        grid.style.gridTemplateColumns = "repeat(" + Coordinate.NUMBER_COLUMNS + ", 55px); ";
        grid.style.gridTemplateRows = "repeat(" + Coordinate.NUMBER_ROWS + ", 55px); ";
        for (let i = Coordinate.NUMBER_ROWS - 1; i >= 0; i--) {
            for (let j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                let cell = document.createElement("div");
                // if (i === Coordinate.NUMBER_ROWS - 1) {
                //     cell.setAttribute("class", "cell first-line");
                //  } else {
                cell.setAttribute("class", "cell");
                //  }
                new ColorView(this.#board.getColor(new Coordinate(i, j))).write(cell);
                grid.appendChild(cell);
            }
        }
        document.getElementById("app").appendChild(grid);
    }

}

export { BoardView, ColorView };