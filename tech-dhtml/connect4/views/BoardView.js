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
    #board;

    constructor(board) {
        this.#board = board;
    }
    //TODO: separar en create y update
    writeln() { 
        let grid= document.createElement("div");
        grid.setAttribute("class","grid");
        grid.style.gridTemplateColumns="repeat("+Coordinate.NUMBER_COLUMNS+", 55px); ";
        grid.style. gridTemplateRows="repeat("+Coordinate.NUMBER_ROWS+", 55px); ";
        for (let i = Coordinate.NUMBER_ROWS - 1; i >= 0; i--) {
            for (let j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                let cell= document.createElement("div");
                cell.setAttribute("class","cell");
                cell.style.backgroundColor="blue";
                grid.appendChild(cell);
                //new ColorView(this.#board.getColor(new Coordinate(i, j))).write(); //HTML le pasa el elmemento al que le tiene que poner el fondo de color
            }
            //new Message().writeln(); //CSS
        }
        document.getElementsByTagName("body").appendChild(grid);
       // this.#writeHorizontal(); //CSS
    }

}

export { BoardView, ColorView };