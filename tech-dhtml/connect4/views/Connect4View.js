
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

    playGame() {
        this.#turnView.setNumberOfHumanPlayers(1);
        this.#boardView.render();
        this.#turnView.getActivePlayer().accept(this);

    }

    play(column) {
        if (this.#turnView.isValidColumn(column)) {
            this.#turnView.play(column);
            this.#boardView.render();
        }
        if (this.#boardView.isFinished()) {
            this.#turnView.writeResult();
        }
        else {
            this.#turnView.getActivePlayer().accept(this);
        }
    }

    visitHumanPlayer(humanPlayer) {
        this.#turnView.renderTurnControls(this);
    }
    visitRandomPlayer(randomPlayer) {
        setTimeout(() => {
            this.play(randomPlayer.getColumn());
        }, 500);
    }

}

window.onload = () => {
    new Connect4View().playGame();
}