import { Board } from './Board.js';
import { Turn } from './Turn.js';

export class Game {

    #board;
    #turn;

    constructor(numOfPlayers) {
        this.#board = new Board();
        this.#turn = new Turn(this.#board, numOfPlayers);
    }

    getColor(coordinate){
        return this.#board.getColor(coordinate);
    }

    getActivePlayer(){
        return this.#turn.getActivePlayer();
    }

    next(){
        this.#turn.next();
    }

    isComplete() {
        return this.#board.isComplete();
    }

    isWinner() {
        return this.#board.isWinner();
    }

    isFinished() {
        return this.#board.isFinished();
    }

    getTurn(){
        return this.#turn
    }

    getBoard(){
        return this.#board
    }

}