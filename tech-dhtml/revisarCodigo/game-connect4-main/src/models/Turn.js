import { Color } from '../types/Color.js';
import { UserPlayer } from './UserPlayer.js';
import { RandomMachinePlayer } from './RandomMachinePlayer.js';

export class Turn {

    static #NUMBER_PLAYERS = 2;
    #players;
    #activePlayer;
    #board;

    constructor(board, numOfPlayers) {
        this.#board = board;
        this.#players = [];

        for (let i = 0; i < Turn.#NUMBER_PLAYERS; i++) {
            this.#players[i] = i < numOfPlayers ?
              new UserPlayer(Color.get(i), this.#board) :
              new RandomMachinePlayer(Color.get(i), this.#board);
        }
        this.#activePlayer = 0;
    }

    next() {
        if (!this.#board.isFinished()) {
            this.#activePlayer = (this.#activePlayer + 1) % Turn.#NUMBER_PLAYERS;
        }
    }

    getActivePlayer(){
        return this.#players[this.#activePlayer];
    }
    
}