import { Coordinate } from '../models/Board.js';
export class TurnView {
    #turn;
    #turnDiv;

    constructor(turn) {
        this.#turn = turn;
        this.#turnDiv = document.getElementById("turnDiv");
        this.#turnDiv.innerHTML = "";
    }

    setNumberOfHumanPlayers(numberOfHumanPlayers) {
        this.#turn.reset(numberOfHumanPlayers);
    }

    renderTurn() {
        this.#turnDiv.innerHTML = `Turn: ${this.getActivePlayer().getColor().getString()}`;
    }

    getActivePlayer() {
        return this.#turn.getActivePlayer();
    }

    renderInvalidColumn(column) { 
            this.#turnDiv.innerHTML = ` Invalid column!!! ${column} 's completed`;
    }

    play(column) {
        this.column = column;
        this.#turn.getActivePlayer().accept(this);
    }

    renderResults() {
        if ((this.#turn.getBoard()).isWinner()) {
            this.#turnViewDiv.innerHTML = `${this.getActivePlayer().getColor().getString()}s WIN!!! : -)`;
        } else {
            this.#turnViewDiv.innerHTML = `TIED!!!`;
        }
    }

    visitHumanPlayer(humanPlayer) {
        if(humanPlayer.isComplete(this.column)){
            this.renderInvalidColumn(this.column);
        }
        else {
            this.#turn.play(this.column);
            delete this.column;
        }
    }
    visitRandomPlayer(randomPlayer) {
        const selectedColumn=randomPlayer.getColumn();
        document.getElementById("randomPlayerDiv").innerHTML=`Choosed radom column: ${selectedColumn+1}`;
        this.#turn.play(selectedColumn);
    }


}