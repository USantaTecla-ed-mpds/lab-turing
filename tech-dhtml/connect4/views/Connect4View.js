
import { Board } from '../models/Board.js';
import { Turn } from '../models/Turn.js';
import { BoardView } from './BoardView.js';
import { TurnView } from './TurnView.js';
import { assert } from '../utils/assert.js';
import { NumPlayersDialog, ResumeDialog} from '../utils/views/Dialog.js';

export class Connect4View {
    #boardView;
    #turnView;

    constructor() {
        this.#init()
    }

    #init(){
        new NumPlayersDialog((numberOfHumanPlayers) => {
            document.getElementById("randomPlayerDiv").innerHTML="";
            this.numberOfHumanPlayers=numberOfHumanPlayers;
            const board = new Board();
            this.#boardView = new BoardView(board);
            this.#turnView = new TurnView(new Turn(board));
            this.#turnView.setNumberOfHumanPlayers(numberOfHumanPlayers);
            this.#turnView.renderTurn();
            this.#boardView.render();
            if (numberOfHumanPlayers > 0) {
                this.#boardView.addUpdateListener(this.#onUpdate.bind(this))
              } else {
                this.#turnView.getActivePlayer().accept(this)
              }
            
        });
    }

    #onUpdate(column) {
        assert(!this.#boardView.isWinner(),"Game is finished");
    
        this.#turnView.play(column);
        this.#turnView.renderTurn();
        this.#boardView.render();
        if (this.numberOfHumanPlayers > 0) {
          this.#boardView.addUpdateListener(this.#onUpdate.bind(this))
        }
        if (!this.#boardView.isFinished()) {
          this.#turnView.getActivePlayer().accept(this)
        } else {
          this.#turnView.renderResults()
          new ResumeDialog(() => {
            this.#init()
          })
        }
      }

    visitHumanPlayer(humanPlayer) {
      
    }
    visitRandomPlayer(randomPlayer) {
        setTimeout(() => {
            this.#onUpdate()
          }, 300)
    }

}

window.onload = () => {
    new Connect4View();
}