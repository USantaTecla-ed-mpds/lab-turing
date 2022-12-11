import { Coordinate } from '../models/Board.js';

export class BoardView {

    #board;

    constructor(board) {
        this.#board = board;
    }
    render() {
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
                cell.setAttribute("class", "cell");
                cell.style.backgroundColor=this.#board.getColor(new Coordinate(i, j)).getString();
                grid.appendChild(cell);
            }
        }
        document.getElementById("boardViewDiv").appendChild(grid);
    }

    isFinished(){
       return this.#board.isFinished();
    }

}