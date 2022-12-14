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
        this.#turnDiv.innerHTML = `Turn: ${this.getActivePlayer().getColor().toString()}`;
    }

    getActivePlayer() {
        return this.#turn.getActivePlayer();
    }

    renderInvalidColumn(column) { 
        document.getElementById("infoDiv").innerHTML = ` Invalid column!!! ${column+1} 's completed`;
    }

    play(column) {
        this.column = column;
        this.#turn.getActivePlayer().accept(this);
    }

    renderResults() {
        if ((this.#turn.getBoard()).isWinner()) {
            this.#turnDiv.innerHTML = `${this.getActivePlayer().getColor().toString()}s WIN!!! : -)`;
        } else {
            this.#turnDiv.innerHTML = `TIED!!!`;
        }
    }

    visitHumanPlayer(humanPlayer) {
        document.getElementById("infoDiv").innerHTML="";
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
        document.getElementById("infoDiv").innerHTML=`Choosed radom column: ${selectedColumn+1}`;
        this.#turn.play(selectedColumn);
    }


}