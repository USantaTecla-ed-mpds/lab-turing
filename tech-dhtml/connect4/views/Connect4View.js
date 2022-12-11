
import { Board } from '../models/Board.js';
import { Turn } from '../models/Turn.js';
import { BoardView } from './BoardView.js';
import { TurnView } from './TurnView.js';

export class Connect4View {
    #boardView;
    #turnView;

    constructor() {
        const board = new Board();
        this.#boardView = new BoardView(board);
        this.#turnView = new TurnView(new Turn(board));
    }

    askHumanPlayers(){
        this.#boardView.render();
        this.#turnView.renderControlsNumberOfPlayer(this);
    }

    playGame(numberOfPlayers) {
        this.#turnView.setNumberOfHumanPlayers(numberOfPlayers);
        this.#boardView.render();
        this.#turnView.getActivePlayer().accept(this);

    }

    play(column) {
        this.#turnView.play(column);
        this.#boardView.render();
   
        if (this.#boardView.isFinished()) {
            this.#turnView.writeResult();
            this.#turnView.renderControlsPlayAgain(this);
        }
        else {
            this.#turnView.getActivePlayer().accept(this);
        }
       
    }

    visitHumanPlayer(humanPlayer) {
        console.log("esperando click");
        this.#turnView.renderTurnControls(this);
    }
    visitRandomPlayer(randomPlayer) {
        setTimeout(() => {
            const selectedColumn=randomPlayer.getColumn();
            document.getElementById("randomPlayerViewDiv").innerHTML =`Choosed radom column: ${selectedColumn+1}`;
            this.play(selectedColumn);
        }, 500);
    }

}

window.onload = () => {
    new Connect4View().askHumanPlayers();
}