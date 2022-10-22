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

class Coordinate {

  static MAX_ROWS = 6;
  static NUMBER_ROWS = new ClosedInterval(0, Coordinate.MAX_ROWS - 1);
  static MAX_COLUMNS = 7;
  static NUMBER_COLUMNS = new ClosedInterval(0, Coordinate.MAX_COLUMNS - 1);
  #row;
  #column;

  constructor(row, column) {
    this.#row = row;
    this.#column = column;
  }

  getRow() {
    return this.#row;
  }

  getColumn() {
    return this.#column;
  }

  getShifted(coordinate) {
    return new Coordinate(this.#row + coordinate.getRow(), this.#column + coordinate.getColumn());
  }

  static isRowValid(row) {
    return Coordinate.NUMBER_ROWS.isIncluded(row);
  }
  
  static isColumnValid(column) {
    return Coordinate.NUMBER_COLUMNS.isIncluded(column);
  }
}

class Direction {

  static SOUTH = new Direction(-1, 0);
  static WEST = new Direction(0, -1);
  static SOUTH_WEST = new Direction(-1, -1);
  static NORTH_WEST = new Direction(1, -1);
  #coordinate;

  constructor(row, column) {
      this.#coordinate = new Coordinate(row, column);
  }

  getCoordinate() {
    return this.#coordinate;
  }

  getOppocite() {
    return new Direction(this.#coordinate.getRow() * -1, this.#coordinate.getColumn() * -1);
  }

  static values() {
    return [Direction.SOUTH, Direction.WEST, Direction.SOUTH_WEST, Direction.NORTH_WEST];
  }
}

class Line {

  static LENGTH = 4;
  #coordinates;

  constructor(initialCoordinate, direction) {
    this.#coordinates = [initialCoordinate];
    for (let i = 0; i < Line.LENGTH - 1; i++) {
      this.#coordinates.push(this.#coordinates[i].getShifted(direction.getCoordinate()));
    }
  }

  getCoordinate(ordinal) {
    return this.#coordinates[ordinal];
  }

  shiftOne(direction) {
    this.#coordinates = this.#coordinates.map(coordinate => coordinate.getShifted(direction.getCoordinate()));
  }
}

class Board {

  #EMPTY_CELL = undefined;
  #cells;
  #currentCoordinate;

  constructor() {
    this.#cells = Array.from(Array(Coordinate.MAX_ROWS), () => Array(Coordinate.MAX_COLUMNS));
  }

  #calculateRow(column) {
    for (let row = 0; row < this.#cells.length; row++) {
      if (this.#cells[row][column] === this.#EMPTY_CELL) {
        return row;
      }
    }
  }

  #isConnect4(line) {
    const COLOR = this.getColor(line.getCoordinate(0));
    for (let i = 1; i < Line.LENGTH; i++) {
      if (this.getColor(line.getCoordinate(i)) !== COLOR) {
        return false;
      }
    }
    return true;
  }

  getColor(coordinate) {
    if (Coordinate.isRowValid(coordinate.getRow())) {
      return this.#cells[coordinate.getRow()][coordinate.getColumn()];
    }
  }

  dropToken(column, color) {
    const row = this.#calculateRow(column);
    this.#cells[row][column] = color;
    this.#currentCoordinate = new Coordinate(row, column);
  }

  isComplete(column) {
    if (column !== undefined) {
      return this.#cells[Coordinate.MAX_ROWS - 1][column] !== this.#EMPTY_CELL;
    }
    for (let i = 0; i < Coordinate.MAX_COLUMNS; i++) {
      if (!this.isComplete(i)) {
        return false;
      }
    }
    return true;
  }

  isWinner() {
    const DIRECTIONS = Direction.values();
    let isWinner = false;
    for (let i = 0; !isWinner && i < DIRECTIONS.length; i++) {
      let line = new Line(this.#currentCoordinate, DIRECTIONS[i]);
      isWinner = this.#isConnect4(line);
      for (let j = 0; !isWinner && j < Line.LENGTH - 1; j++) {
        line.shiftOne(DIRECTIONS[i].getOppocite());
        isWinner = this.#isConnect4(line);
      }
    }
    return isWinner;
  }
}

class Color {

  static RED = new Color(`RED`);
  static YELLOW = new Color(`YELLOW`);
  #string;

  constructor(string) {
    this.#string = string;
  }

  static get(ordinal) {
    return Color.#values()[ordinal];
  }

  static #values() {
    return [Color.RED, Color.YELLOW];
  }

  toString() {
    return this.#string;
  }
}

class Player {

  #color;
  #board;

  constructor(color) {
    this.#color = color;
  }

  set board(board) {
    this.#board = board;
  }

  getColor() {
    return this.#color.toString();
  }

  isComplete(column) {
      return this.#board.isComplete(column);
  }

  dropToken(column) {
    this.#board.dropToken(column, this.#color.toString().charAt());
  }
}

class Human extends Player {

  constructor(color) {
    super(color);
  }

  dropToken(column) {
    if (!Coordinate.isColumnValid(column)) 
      return `Remember columns between 1 and 7`;
    if (this.isComplete(column)) 
      return `This column is full`;
    super.dropToken(column);
  }
}

class Random extends Player {

  constructor(color) {
    super(color);
  }

  dropToken() {
    let column;
    do {
      column = parseInt(Math.random() * 7);
    } while (this.isComplete(column));
    super.dropToken(column);
  }
}

class Turn {

  static MAX_PLAYERS = 2;
  static NUMBER_PLAYER = new ClosedInterval(0, Turn.MAX_PLAYERS);
  #currentTurn = 0;
  #players = [];
  #board;

  constructor(board) {
    this.#board = board;
  }

  addPlayer(player) {
    player.board = this.#board;
    this.#players.push(player);
  }

  getCurrentPlayer() {
    return this.#players[this.#currentTurn];
  }

  changeTurn() {
    this.#currentTurn = (this.#currentTurn + 1) % Turn.MAX_PLAYERS;
  }

  getCurrentTurn() {
    return this.#currentTurn;
  }

  static isNumberPlayerValid(number) {
    return Turn.NUMBER_PLAYER.isIncluded(number);
  }
}

class Game {

  #board;
  #turn;

  constructor() {
    this.#board = new Board();
    this.#turn = new Turn(this.#board);
  }

  getBoard() {
    return this.#board;
  }

  getTurn() {
    return this.#turn;
  }

  getCurrentPlayer() {
    return this.#turn.getCurrentPlayer();
  }

  changeTurn() {
    this.#turn.changeTurn();
  }

  isWinner() {
    return this.#board.isWinner();
  }

  isFinished() {
    return this.#board.isWinner() || this.#board.isComplete();
  }
}

class BoardView {

  #board;

  constructor(board) {
    this.#board = board;
  }

  writeln() {
    console.writeln(`* 1 2 3 4 5 6 7`);
    for (let row = Coordinate.MAX_ROWS - 1; row >= 0; row--) {
      console.write(`${row + 1} `);
      for (let column = 0; column < Coordinate.MAX_COLUMNS; column++) {
        console.write(`${this.#board.getColor(new Coordinate(row, column)) || "_"},`);
      }
      console.writeln();
    }
  }
}

class PlayerView {

  player;
  constructor(player) {
    this.player = player;
  }

  writeTitle() {
    console.writeln(`--------------------------`);
  }
}

class HumanView extends PlayerView {

  constructor(player) {
    super(player);
  }

  dropToken() {
    let error;
    do {
      this.writeTitle();
      let column = console.readNumber(`Player ${this.player.getColor()} Select column between (1 - 7)`) - 1;
      error = this.player.dropToken(column);
      if (error) {
        console.writeln(error);
      }
    } while (error);
  }
}

class RandomView extends PlayerView {

  constructor(player) {
    super(player);
  }

  dropToken() {
    this.writeTitle();
    this.player.dropToken();
  }
}

class TurnView {

  #turn;
  #playersView = [];

  constructor(turn) {
    this.#turn = turn;
  }

  config() {
    let response;
    let error = false;
    do {
      response = console.readNumber(`Tell me the number of human players (until 2)`);
      error = !Turn.isNumberPlayerValid(response)
      if (error) {
        console.writeln(`This number of human players is not valid!`);
      }
    } while (error);
    for (let i = 0; i < Turn.MAX_PLAYERS; i++) {
      const player = (i < response) ? new Human(Color.get(i)) : new Random(Color.get(i));
      this.#turn.addPlayer(player);
      this.#playersView.push((player instanceof Human) ? new HumanView(player) : new RandomView(player));
    }
  }

  play() {
    this.#playersView[this.#turn.getCurrentTurn()].dropToken();
  }
}

class GameView {

  #game;
  #boardView;
  #turnView;

  constructor() {
    this.#game = new Game();;
    this.#boardView = new BoardView(this.#game.getBoard());
    this.#turnView = new TurnView(this.#game.getTurn());
  }

  play() {
    console.writeln(`----- CONNECT4 -----`);
    this.#turnView.config();
    let gameFinished;
    do {
      this.#boardView.writeln();
      this.#turnView.play();
      gameFinished = this.#game.isFinished();
      if (!gameFinished) {
        this.#game.changeTurn();
      }
    } while (!gameFinished);
    this.#writeResult();
  }

  #writeResult() {
    this.#boardView.writeln();
    console.writeln(this.#game.isWinner() ? `The winner is the player ${this.#game.getCurrentPlayer().getColor()}` : `Tied Game`);
  }
}

class YesNoDialogView {

  #question;
  #answer;

  constructor(question) {
    this.#question = question;
  }

  read() {
    let error;
    do {
      this.#answer = console.readString(this.#question);
      error = !this.isAffirmative() && !this.isNegative();
      if (error) {
        console.writeln(`Please answer "yes" or "no"`);
      }
    } while (error);
  }

  isAffirmative() {
    return this.#answer === `yes`;
  }

  isNegative() {
    return this.#answer === `no`;
  }
}

class Connect4View {

  play() {
    const continueDialogView = new YesNoDialogView(`Do you want to continue? (yes/no)`);
    do {
      new GameView().play();
      continueDialogView.read();
    } while (continueDialogView.isAffirmative());
  }
}

new Connect4View().play();

module.exports.Game = Game;
module.exports.Coordinate = Coordinate;