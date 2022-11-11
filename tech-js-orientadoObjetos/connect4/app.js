const { Console } = require("console-mpds");

const console = new Console();

class Message {
    static TITLE = new Message(`--- CONNECT 4 ---`);
    static NUM_PLAYERS = new Message(`Enter number of human players: `);
    static HORIZONTAL_LINE = new Message(`-`);
    static VERTICAL_LINE = new Message(`|`);
    static TURN = new Message(`Turn: `);
    static ENTER_COLUMN_TO_DROP = new Message(`Enter a column to drop a token: `);
    static INVALID_COLUMN = new Message(`Invalid columnn!!! Values [1-7]`);
    static COMPLETED_COLUMN = new Message(`Invalid column!!! It's completed`);
    static RANDOM_COLUMN = new Message(`Choosed radom column: `);
    static PLAYER_WIN = new Message(`#colorS WIN!!! : -)`);
    static PLAYERS_TIED = new Message(`TIED!!!`);
    static RESUME = new Message(`Do you want to continue`);

    #string;

    constructor(string) {
        this.#string = string;
    }

    write() {
        console.write(this.#string);
    }

    writeln() {
        console.writeln(this.#string);
    }

    toString() {
        return this.#string;
    }

}
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

    write() {
        console.write(` ${this.#string.getString()[0]} `);
    }
    toString() {
        return this.#string.getString();
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
    #line;

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
            this.#setLine(direction);
            for (let i = 0; i < Board.LINE_LENGTH; i++) {
                if (this.#isConnect4()) {
                    return true;
                }
                let oppositeDirection = direction.getOpposite();
                for (let j = 0; j < Board.LINE_LENGTH; j++) {
                    this.#line[j] = this.#line[j].shifted(oppositeDirection.getCoordinate());
                }
            }
        }
        return false;
    }

    #setLine(direction) {
        this.#line = [this.#lastDrop];
        for (let i = 1; i < Board.LINE_LENGTH; i++) {
            this.#line[i] = this.#line[i - 1].shifted(direction.getCoordinate());
        }
    }

    #isConnect4() {
        for (let i = 0; i < Board.LINE_LENGTH; i++) {
            if (!this.#line[i].isValid()) {
                return false;
            }
            if (i > 0 && this.getColor(this.#line[i - 1]) != this.getColor(this.#line[i])) {
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
            Message.VERTICAL_LINE.write();
            for (let j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                new Color(this.#board.getColor(new Coordinate(i, j))).write();
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

    accept() { }
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

class PlayerView {
    #player;

    constructor(player) {
        this.#player = player;
    }

    writeWinner() {
        let message = Message.PLAYER_WIN.toString();
        message = message.replace(`#color`, new Color(this.#player.getColor()).toString());
        new Message(message).writeln();
    }

    getColumn() { }

    getPlayer() {
        return this.#player;
    }
}
class HumanPlayerView extends PlayerView {

    constructor(player) {
        super(player);
    }

    getColumn() {
        let column;
        let valid;
        do {
            Message.TURN.write();
            new Message(new Color(super.getPlayer().getColor()).toString()).writeln();
            column = console.readNumber(Message.ENTER_COLUMN_TO_DROP.toString()) - 1;
            valid = Coordinate.isColumnValid(column);
            if (!valid) {
                Message.INVALID_COLUMN.writeln();
            } else {
                valid = !super.getPlayer().isComplete(column);
                if (!valid) {
                    Message.COMPLETED_COLUMN.writeln();
                }
            }
        } while (!valid);
        return column;
    }
}
class RandomPlayerView extends PlayerView {

    getColumn() {
        Message.TURN.write();
        new Message(new Color(super.getPlayer().getColor()).toString()).writeln();
        let column = this.getPlayer().getColumn();
        Message.RANDOM_COLUMN.write();
        new Message(column + 1).writeln();
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
    }
    reset(humanPlayers) {
        for (let i = 0; i < Turn.#NUMBER_PLAYERS; i++) {
            this.#players[i] = i < humanPlayers ?
                new HumanPlayer(Color.get(i), this.#board) :
                new RandomPlayer(Color.get(i), this.#board);
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
    getNumberPlayers() {
        return Turn.#NUMBER_PLAYERS;
    }
}

class OptionDialog {

    option1;
    option2;
    message;
    suffix;
    #answer;

    constructor(option1, option2) {
        this.option1 = option1;
        this.option2 = option2;
        this.message = `The value must be between ${this.option1} or ${this.option2}`;
        this.suffix = `? [` +
            this.option1 + `-` +
            this.option2 + `]: `
    }

    read(message) {
        let ok;
        do {
            new Message(message).write();
            this.#answer = this.readWithSuffix();
            ok = this.isOk();
            if (!ok) {
                new Message(message).writeln();
            }
        } while (!ok);
    }

    readWithSuffix() {
    }

    isOk() { }

    getAnswer() {
        return this.#answer;
    }
}
class InIntervalDialog extends OptionDialog {

    constructor(min, max) {
        super(min, max);
        this.message = `The value must be between ${min} and ${max}`;
        this.suffix = `? [` +
            min + `-` +
            max + `]: `
    }

    readWithSuffix() {
        return console.readNumber(this.suffix);
    }

    isOk() {
        return new ClosedInterval(this.option1, this.option2).isIncluded(this.getAnswer());
    }

}

class PlayerVisitor {
    #activePlayerView;

    visitHumanPlayer(humanPlayer) {
         this.#activePlayerView = new HumanPlayerView(humanPlayer);
    }
    visitRandomPlayer(randomPlayer) {
        this.#activePlayerView = new RandomPlayerView(randomPlayer);
    }
    getActivePlayerView(){
        return this.#activePlayerView;
    }
}
class TurnView extends PlayerVisitor {
    #turn;
    #activePlayerView;

    constructor(turn) {
        super();
        this.#turn = turn;
    }
    readNummberOfHumanPlayers() {
        let inIntervalDialog = new InIntervalDialog(0, this.#turn.getNumberPlayers());
        inIntervalDialog.read(Message.NUM_PLAYERS.toString());
        return inIntervalDialog.getAnswer();
    }

    play() {
        this.#turn.getActivePlayer().accept(this);
        this.#activePlayerView = super.getActivePlayerView();
        this.#turn.play(this.#activePlayerView.getColumn());
    }

    writeResult() {
        if ((this.#turn.getBoard()).isWinner()) {
            this.#activePlayerView.writeWinner();
        } else {
            Message.PLAYERS_TIED.writeln();
        }
    }
}
class YesNoDialog extends OptionDialog {

    static #AFFIRMATIVE = `y`;
    static #NEGATIVE = `n`;

    constructor() {
        super(YesNoDialog.#AFFIRMATIVE, YesNoDialog.#NEGATIVE);
        this.message = `The value must be ${YesNoDialog.#AFFIRMATIVE} or ${YesNoDialog.#NEGATIVE}`;
        this.suffix = `? (` +
            YesNoDialog.#AFFIRMATIVE + `/` +
            YesNoDialog.#NEGATIVE + `): `;
    }

    readWithSuffix() {
        return console.readString(this.suffix);
    }

    isOk() {
        return this.isAffirmative() || this.isNegative();
    }

    isAffirmative() {
        return this.getAnswer() === YesNoDialog.#AFFIRMATIVE;
    }

    isNegative() {
        return this.getAnswer() === YesNoDialog.#NEGATIVE;
    }

    getAnswer() {
        return super.getAnswer().toLowerCase()[0];
    }
}

class Connect4 {

    #board;
    #turn;
    #boardView;
    #turnView;
    #humanPlayers;

    constructor() {
        this.#board = new Board();
        this.#boardView = new BoardView(this.#board);
        this.#turn = new Turn(this.#board);
        this.#turnView = new TurnView(this.#turn);
    }

    playGames() {
        do {
            this.#playGame();
        } while (this.#isResumed());
    }

    #playGame() {
        this.#humanPlayers = this.#turnView.readNummberOfHumanPlayers();
        this.#turn.reset(this.#humanPlayers);
        Message.TITLE.writeln();
        this.#boardView.writeln();

        do {
            this.#turnView.play();
            this.#boardView.writeln();
        } while (!this.#board.isFinished());
        this.#turnView.writeResult();
    }

    #isResumed() {
        let yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.#board.reset();
        }
        return yesNoDialog.isAffirmative();
    }
}
new Connect4().playGames();
