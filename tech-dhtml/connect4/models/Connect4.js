import { Board } from '../models/Board.js';
import { Turn } from '../models/Turn.js';

export class Connect4{
    #board;
    #turn;

    constructor() {
       this.#board = new Board();
       this.#turn= new Turn(this.#board)
    }

    getBoard(){
        return this.#board;
    }
    getTurn(){
        return this.#turn;
    }
   toJSON(){
        return {
            board: this.#board.toJSON(),
            turn: this.#turn.toJSON()
        }
    }
    fromJSON(connect4){
        this.#board.fromJSON(connect4.board);
        this.#turn.fromJSON(connect4.turn);
    }
}