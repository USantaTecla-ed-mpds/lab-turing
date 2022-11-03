const { Console } = require("console-mpds");

const console = new Console();

class ClosedInterval {

    #min;
    #max;

    constructor(min, max) {
        this.#min = min;
        this.#max = max;
    }

    isIncluded(value) {
        return this.#min <= value && value <= this.#max;
    }

}

class Color {

    static RED = new Color(`Red`);
    static YELLOW = new Color(`Yellow`);
    static NULL = new Color(` `);
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

    getString() {
        return this.#string;
    }
}


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

    toString() {
        return `Coordinate [row= ${this.#row} column= ${this.#column}]`;
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

class Message {
    static TITLE = new Message(`--- CONNECT 4 ---`);
    static HORIZONTAL_LINE = new Message(`-`);
    static VERTICAL_LINE = new Message(`|`);
    static TURN = new Message(`Turn: `);
    static ENTER_COLUMN_TO_DROP = new Message(`Enter a column to drop a token: `);
    static INVALID_COLUMN = new Message(`Invalid columnn!!! Values [1-7]`);
    static COMPLETED_COLUMN = new Message(`Invalid column!!! It's completed`);
    static PLAYER_WIN = new Message(`#colorS WIN!!! : -)`);
    static PLAYERS_TIED = new Message(`TIED!!!`);
    static RESUME = new Message(`Do you want to continue`);

    #string;

    constructor(string) {
        this.#string = string;
    }

    getString() {
        return this.#string;
    }

}

class MessageView {
    #message;

    constructor(message) {
        this.#message = message;
    }
    write() {
        console.write(this.#message.getString());
    }

    writeln() {
        console.writeln(this.#message.getString());
    }

    toString() {
        return this.#message.getString();
    }

}

class Line {

    static LENGTH = 4;
    #origin;
    #coordinates;
    #oppositeDirection;

    constructor(coordinate) {
        this.#origin = coordinate;
    }

    set(direction) {
        this.#coordinates = [this.#origin];
        for (let i = 1; i < Line.LENGTH; i++) {
            this.#coordinates[i] = this.#coordinates[i - 1].shifted(direction.getCoordinate());
        }
        this.#oppositeDirection = direction.getOpposite();
    }

    shift() {
        for (let i = 0; i < Line.LENGTH; i++) {
            this.#coordinates[i] = this.#coordinates[i].shifted(this.#oppositeDirection.getCoordinate());
        }
    }

    getCoordinates() {
        return this.#coordinates;
    }
}

class Board {

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
        let line = new Line(this.#lastDrop);
        for (let direction of Direction.halfValues()) {
            line.set(direction);
            for (let i = 0; i < Line.LENGTH; i++) {
                if (this.isConnect4(line)) {
                    return true;
                }
                line.shift();
            }
        }
        return false;
    }

    isConnect4(line) {
        let coordinates = line.getCoordinates();
        for (let i = 0; i < Line.LENGTH; i++) {
            if (!coordinates[i].isValid()) {
                return false;
            }
            if (i > 0 && this.getColor(coordinates[i - 1]) != this.getColor(coordinates[i])) {
                return false;
            }
        }
        return true;
    }

    isOccupied(coordinate, color) {
        return this.getColor(coordinate) == color;
    }

    isEmpty(coordinate) {
        return this.isOccupied(coordinate, Color.NULL);
    }

    getColor(coordinate) {
        return this.#colors[coordinate.getRow()][coordinate.getColumn()];
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
            new MessageView(Message.VERTICAL_LINE).write();
            for (let j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                new ColorView(this.#board.getColor(new Coordinate(i, j))).write();
                new MessageView(Message.VERTICAL_LINE).write();
            }
            console.writeln();
        }
        this.#writeHorizontal();
    }

    #writeHorizontal() {
        
        for (let i = 0; i < BoardView.BLANK_SPACES * Coordinate.NUMBER_COLUMNS; i++) {
            new MessageView(Message.HORIZONTAL_LINE).write();
        }
        new MessageView(Message.HORIZONTAL_LINE).writeln();
    }

}

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
    getBoard() {
        return this.#board;
    }

}

class PlayerView {
    #player;

    constructor(player) {
        this.#player = player;
    }

    writeWinner() {
        let message = new MessageView(Message.PLAYER_WIN).toString();
        message = message.replace(`#color`, new ColorView(this.#player.getColor()).toString());
        console.writeln(message);
    }

    askColumn() {
        let column;
        let valid;
        do {
            new MessageView(Message.TURN).write();
            console.writeln(new ColorView(this.#player.getColor()).toString());
            column = console.readNumber(new MessageView(Message.ENTER_COLUMN_TO_DROP).toString()) - 1;
            valid = Coordinate.isColumnValid(column);
            if (!valid) {
                new MessageView(Message.INVALID_COLUMN).writeln();
            } else {
                valid = !this.#player.getBoard().isComplete(column);
                if (!valid) {
                    new MessageView(Message.COMPLETED_COLUMN).writeln();
                }
            }
        } while (!valid);
        return column;
    }
}

class Turn {

    static #NUMBER_PLAYERS = 2;
    #players;
    #activePlayer;
    #board;

    constructor(board) {
        this.#board = board;
        this.#players = [];
        this.reset();
    }

    reset() {
        for (let i = 0; i < Turn.#NUMBER_PLAYERS; i++) {
            this.#players[i] = new Player(Color.get(i), this.#board);
        }
        this.#activePlayer = 0;
    }

    play(column) {
        this.#players[this.#activePlayer].play(column);
        if (!this.#board.isFinished()) {
            this.#activePlayer = (this.#activePlayer + 1) % Turn.#NUMBER_PLAYERS;
        }
    }


    getActivePlayer() {
        return this.#players[this.#activePlayer];
    }
    getBoard() {
        return this.#board;
    }
}

class TurnView {
    #turn;
    #activePlayerView;

    constructor(turn) {
        this.#turn = turn;
        this.#activePlayerView = new PlayerView(this.#turn.getActivePlayer());
    }

    play() {
        this.#turn.play(this.#activePlayerView.askColumn());
    }

    writeResult() {
        if ((this.#turn.getBoard()).isWinner()) {
            this.#activePlayerView.writeWinner();
        } else {
            new MessageView(Message.PLAYERS_TIED).writeln();
        }
    }

}

class YesNoDialog {

    static #AFFIRMATIVE = `y`;
    static #NEGATIVE = `n`;
    static #SUFFIX = `? (` +
        YesNoDialog.#AFFIRMATIVE + `/` +
        YesNoDialog.#NEGATIVE + `): `;
    static #MESSAGE = `The value must be ${YesNoDialog.#AFFIRMATIVE} or ${YesNoDialog.#NEGATIVE}`;
    #answer;

    read(message) {
        let ok;
        do {
            console.write(message);
            this.#answer = console.readString(YesNoDialog.#SUFFIX);
            ok = this.isAffirmative() || this.isNegative();
            if (!ok) {
                console.writeln(YesNoDialog.#MESSAGE);
            }
        } while (!ok);
    }

    isAffirmative() {
        return this.getAnswer() === YesNoDialog.#AFFIRMATIVE;
    }

    isNegative() {
        return this.getAnswer() === YesNoDialog.#NEGATIVE;
    }

    getAnswer() {
        return this.#answer.toLowerCase()[0];
    }
}

class Connect4 {

    #board;
    #turn;
    #boardView;
    #turnView;

    constructor() {
        this.#board = new Board();
        this.#turn = new Turn(this.#board);
        this.#boardView = new BoardView(this.#board);
    }

    playGames() {
        do {
            this.playGame();
        } while (this.isResumed());
    }

    playGame() {
        new MessageView(Message.TITLE).writeln();
        this.#boardView.writeln();
        
        do {
            this.#turnView=new TurnView(this.#turn);
            this.#turnView.play();
            this.#boardView.writeln();
        } while (!this.#board.isFinished());
        this.#turnView.writeResult();
    }

    isResumed() {
        let yesNoDialog = new YesNoDialog();
        yesNoDialog.read(new MessageView(Message.RESUME).toString());
        if (yesNoDialog.isAffirmative()) {
            this.#board.reset();
            this.#turn.reset();
        }
        return yesNoDialog.isAffirmative();
    }

}

new Connect4().playGames();