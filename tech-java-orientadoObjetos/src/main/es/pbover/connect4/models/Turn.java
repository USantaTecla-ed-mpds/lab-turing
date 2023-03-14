package main.es.pbover.connect4.models;

public class Turn {
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
                new MinMaxPlayer(Color.get(i), this.#board,4+i*2);
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
