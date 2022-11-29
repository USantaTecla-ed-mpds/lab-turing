
//import { Message } from './views/Message.js';
//import { YesNoDialog }  from './utils/views/Dialog.js';
//import { Board } from './models/Board.js';
//import { Turn } from './models/Turn.js';
//import { BoardView } from './views/BoardView.js';
//import { TurnView } from './views/TurnView.js';

function load() {

  new Connect4().playGames();

};

function setClicked(element) {
  clickedCells = document.getElementsByClassName("clicked");
  for(cell of clickedCells){
    cell.setAttribute("class","first-line cell");
  }
  element.setAttribute("class",element.getAttribute("class")+" clicked");
}

class Connect4 {
  #board;
  #turn;
  #boardView;
  #turnView;

  constructor() {
      this.#board = new Board();
      this.#boardView = new BoardView(this.#board);
      this.#turn = new Turn(this.#board);
      this.#turnView = new TurnView(this.#turn);
  }

  playGames() {
   //   do {
          this.#playGame();
      //} while (this.#isResumed());
  }

  #playGame() {
      this.#turnView.setNumberOfHumanPlayers();
    //  Message.TITLE.writeln();
      this.#boardView.writeln();

     /* do {
          this.#turnView.play();
          this.#boardView.writeln();
      } while (!this.#board.isFinished());*/
      this.#turnView.writeResult();
  }

 /* #isResumed() {
      let yesNoDialog = new YesNoDialog();
      yesNoDialog.read(Message.RESUME.toString());
      if (yesNoDialog.isAffirmative()) {
          this.#board.reset();
      }
      return yesNoDialog.isAffirmative();
  }*/
}
/*Message.js*/
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
      console.log(this.#string);
  }

  writeln() {
      console.log(this.#string);
  }

  toString() {
      return this.#string;
  }

}

/*Dialog.js*/




/*Board.js*/

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
      return this.getColor(coordinate) == color;
  }

  isEmpty(coordinate) {
      return this.isOccupied(coordinate, Color.NULL);
  }

  getColor(coordinate) {
      return this.#colors[coordinate.getRow()][coordinate.getColumn()];
  }

}

/*Turn.js*/

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

/*BoardView*/

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
  writeln() {
      let grid= document.createElement("div");
      grid.setAttribute("class","grid");
      grid.style.gridTemplateColumns="repeat("+Coordinate.NUMBER_COLUMNS+", 55px); ";
      grid.style. gridTemplateRows="repeat("+Coordinate.NUMBER_ROWS+", 55px); ";
      for (let i = Coordinate.NUMBER_ROWS - 1; i >= 0; i--) {
          for (let j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
              let cell= document.createElement("div");
              cell.setAttribute("class","cell");

              grid.appendChild(cell);
              //new ColorView(this.#board.getColor(new Coordinate(i, j))).write(); //HTML le pasa el elmemento al que le tiene que poner el fondo de color
          }
          //new Message().writeln(); //CSS
      }
      document.getElementsByTagName("body")[0].appendChild(grid);
     // this.#writeHorizontal(); //CSS
  }

}

/*TurnView*/
class PlayerView {
  #player;

  constructor(player) {
      this.#player = player;
  }

  writeWinner() {
      let message = Message.PLAYER_WIN.toString();
      message = message.replace(`#color`, new ColorView(this.#player.getColor()).toString());
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
      let column=1;
      /*
      let valid;
      do {
          Message.TURN.write();
          new Message(new ColorView(super.getPlayer().getColor()).toString()).writeln();
         // let inIntervalDialog = new InIntervalDialog(1,Coordinate.NUMBER_COLUMNS); //Click en alguna columna
         // inIntervalDialog.read(Message.ENTER_COLUMN_TO_DROP.toString());
          column = inIntervalDialog.getAnswer()-1;
          valid = !super.getPlayer().isComplete(column);
          if (!valid) {
              Message.COMPLETED_COLUMN.writeln();
          }
      } while (!valid);*/
      //alert("TODO");
      return column;
  }
}
class RandomPlayerView extends PlayerView {

  getColumn() {
      Message.TURN.write();
      new Message(new ColorView(super.getPlayer().getColor()).toString()).writeln();
      let column = this.getPlayer().getColumn();
      Message.RANDOM_COLUMN.write();
      new Message(column + 1).writeln();
      return column;
  }
}


class TurnView extends PlayerVisitor {
  #turn;
  #activePlayerView;

  constructor(turn) {
      super();
      this.#turn = turn;
  }
  setNumberOfHumanPlayers() { 
    /*  let inIntervalDialog = new InIntervalDialog(0, this.#turn.getNumberPlayers());
      inIntervalDialog.read(Message.NUM_PLAYERS.toString());*/

      this.#turn.reset(2/*inIntervalDialog.getAnswer()*/);
  }

  play() {
      this.#turn.getActivePlayer().accept(this);
      this.#turn.play(this.#activePlayerView.getColumn());
  }

  writeResult() {
      if ((this.#turn.getBoard()).isWinner()) {
          this.#activePlayerView.writeWinner();
      } else {
          Message.PLAYERS_TIED.writeln();
      }
  }
  visitHumanPlayer(humanPlayer) {
      this.#activePlayerView = new HumanPlayerView(humanPlayer);
  }
  visitRandomPlayer(randomPlayer) {
      this.#activePlayerView = new RandomPlayerView(randomPlayer);
  }
}
