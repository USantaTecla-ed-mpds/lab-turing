import { HumanPlayer, RandomPlayer } from './Player.js'
import { Color } from './Board.js';

class Turn {

    static #NUMBER_PLAYERS = 2;
    #players;
    #activePlayer;
    #board;


    constructor(board) {
        this.#board = board;
        this.#players = [];
    }
    reset(numberOfHumanPlayers) {
        for (let i = 0; i < Turn.#NUMBER_PLAYERS; i++) {
            this.#players[i] = i < numberOfHumanPlayers ?
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
    #getNumberOfHumanPlayers(){
        this.numberOfHumanPlayers=0;
        this.#players.forEach((player)=>{player.accept(this)})
        let numberOfHumanPlayers=this.numberOfHumanPlayers
        delete this.numberOfHumanPlayers;
        return numberOfHumanPlayers;
    }
    toJSON(){
        return {
            numberOfHumanPlayers: this.#getNumberOfHumanPlayers(),
            activePlayer: this.#activePlayer
        }
    }
    fromJSON(turn){
        this.reset(turn.numberOfHumanPlayers);
        this.#activePlayer=turn.activePlayer;
    }

    visitHumanPlayer() {
        this.numberOfHumanPlayers++;
    }
    visitRandomPlayer() {
    }
}

export { Turn };