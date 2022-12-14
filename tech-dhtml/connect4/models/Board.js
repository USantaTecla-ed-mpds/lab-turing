import ClosedInterval  from '../utils/models/ClosedInterval.js';

class Color {

    static RED = new Color(`Red`);
    static YELLOW = new Color(`Yellow`);
    static NULL = new Color(`White`);
    #string;

    constructor(string) {
        this.#string = string;
    }

    static get(ordinal) {
        return Color.#values()[ordinal];
    }

    static #values() {
        return [Color.RED, Color.YELLOW, Color.NULL];
    }

    static fromString(color) {
        switch (color) {
            case 'Red':
                return Color.RED
            case 'Yellow':
                return Color.YELLOW
            default:
                return Color.NULL
        }
    }

    toString(){
        return this.#string;
    }

}
class Coordinate {

    static ORIGIN = new Coordinate(0, 0);
    static NUMBER_ROWS = 6;
    static #ROWS = new ClosedInterval(0, Coordinate.NUMBER_ROWS - 1);
    static NUMBER_COLUMNS = 7;
    static #COLUMNS = new ClosedInterval(0, Coordinate.NUMBER_COLUMNS - 1);

    #row;
    #column;

    constructor(row, column) {
        this.#row = row;
        this.#column = column;
    }

    shifted(coordinate) {
        return new Coordinate(this.#row + coordinate.#row,
            this.#column + coordinate.#column);
    }

    isValid() {
        return Coordinate.#isRowValid(this.getRow())
            && Coordinate.isColumnValid(this.getColumn());
    }

    static isColumnValid(column) {
        return Coordinate.#COLUMNS.isIncluded(column);
    }

    static #isRowValid(row) {
        return Coordinate.#ROWS.isIncluded(row);
    }

    getRow() {
        return this.#row;
    }

    getColumn() {
        return this.#column;
    }

    equals(coordinate) {
        if (this == coordinate)
            return true;
        if (coordinate == null)
            return false;
        return this.#column === coordinate.#column && this.#row === coordinate.#row;
    }

}
class Direction {
    static NORTH = new Direction(1, 0);
    static NORTH_EAST = new Direction(1, 1);
    static EAST = new Direction(0, 1);
    static SOUTH_EAST = new Direction(-1, 1);
    static SOUTH = new Direction(-1, 0);
    static SOUTH_WEST = new Direction(-1, -1);
    static WEST = new Direction(0, -1);
    static NORTH_WEST = new Direction(1, -1);

    #coordinate;

    constructor(row, column) {
        this.#coordinate = new Coordinate(row, column);
    }

    getOpposite() {
        for (let direction of Direction.values()) {
            if (direction.#coordinate.shifted(this.#coordinate).equals(Coordinate.ORIGIN)) {
                return direction;
            }
        }
        return null;
    }

    static values() {
        return [Direction.NORTH, Direction.NORTH_EAST, Direction.EAST, Direction.SOUTH_EAST,
        Direction.SOUTH, Direction.SOUTH_WEST, Direction.WEST, Direction.NORTH_WEST];
    }

    getCoordinate() {
        return this.#coordinate;
    }

    static halfValues() {
        return Direction.values().splice(0, Direction.values().length / 2);
    }

}
class Board {
    static LINE_LENGTH = 4;
    #colors;
    #lastDrop;

    constructor() {
        this.#colors = [];
        for (let i = 0; i < Coordinate.NUMBER_ROWS; i++) {
            this.#colors[i] = [];
        }
        this.reset();
    }

    reset() {
        for (let i = 0; i < Coordinate.NUMBER_ROWS; i++) {
            for (let j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                this.#colors[i][j] = Color.NULL;
            }
        }
    }

    dropToken(column, color) {
        this.#lastDrop = new Coordinate(0, column);
        while (!this.isEmpty(this.#lastDrop)) {
            this.#lastDrop = this.#lastDrop.shifted(Direction.NORTH.getCoordinate());
        }
        this.#colors[this.#lastDrop.getRow()][this.#lastDrop.getColumn()] = color;
    }

    isComplete(column) {
        if (column !== undefined) {
            return !this.isEmpty(new Coordinate(Coordinate.NUMBER_ROWS - 1, column));
        }
        for (let i = 0; i < Coordinate.NUMBER_COLUMNS; i++) {
            if (!this.isComplete(i)) {
                return false;
            }
        }
        return true;
    }

    isFinished() {
        return this.isComplete() || this.isWinner();
    }

    isWinner() {
        if (this.#lastDrop === undefined) {
            return false;
        }
        for (let direction of Direction.halfValues()) {
            let line = [this.#lastDrop];
            this.#setLine(line, direction);
            for (let i = 1; i < Board.LINE_LENGTH; i++) {
                line[i] = line[i - 1].shifted(direction.getCoordinate());
            }
            for (let i = 0; i < Board.LINE_LENGTH; i++) {
                if (this.#isConnect4(line)) {
                    return true;
                }
                this.#shiftLine(line, direction);
            }
        }
        return false;
    }

    #setLine(line, direction) {
        for (let i = 1; i < Board.LINE_LENGTH; i++) {
            line[i] = line[i - 1].shifted(direction.getCoordinate());
        }
    }
    #shiftLine(line, direction) {
        let oppositeDirection = direction.getOpposite();
        for (let j = 0; j < Board.LINE_LENGTH; j++) {
            line[j] = line[j].shifted(oppositeDirection.getCoordinate());
        }
    }

    #isConnect4(line) {
        for (let i = 0; i < Board.LINE_LENGTH; i++) {
            if (!line[i].isValid()) {
                return false;
            }
            if (i > 0 && this.getColor(line[i - 1]) != this.getColor(line[i])) {
                return false;
            }
        }
        return true;
    }

    isOccupied(coordinate, color) {
        return this.getColor(coordinate) === color;
    }

    isEmpty(coordinate) {
        return this.isOccupied(coordinate, Color.NULL);
    }

    getColor(coordinate) {
        return this.#colors[coordinate.getRow()][coordinate.getColumn()];
    }

    toJSON(){
        return {
            colors: this.#colors.map(color=>color.toString()),
            lastDropRow: this.#lastDrop.getRow(),
            lastDropColumn: this.#lastDrop.getColumn()
        }
    }
    fromJSON(board){
        this.#colors=[];
        board.colors.forEach((row,rowIndex)=>{
            this.#colors[rowIndex]=[];
            row.split(",").forEach((color,columnIndex)=>{
                this.#colors[rowIndex][columnIndex]=Color.fromString(color); //Solucionar new Color(string)
            });
        });
        this.#lastDrop= new Coordinate(board.lastDropRow,board.lastDropColumn);
    }

}

export { Board, Color, Coordinate };

/*
static fromString(color) {
        switch (color) {
            case 'Red':
                return Color.RED
            case 'Yellow':
                return Color.YELLOW
            default:
                return Color.NULL
        }
    }
this.#colors[rowKey][columnKey] = Color.fromString(color)
*/
