import { BoardView } from './BoardView.js';
import { TurnView } from './TurnView.js';
import { assert } from '../utils/assert.js';
import { NumPlayersDialog, ResumeDialog} from '../utils/views/Dialog.js';
import { Connect4 } from '../models/Connect4.js';
import { StorageView } from './StorageView.js';

export class Connect4View {
    #connect4;
    #boardView;
    #turnView;
    #storageView;

    constructor() {
        this.#init();
        this.#storageView= new StorageView(this.#loadGame.bind(this));
    }

    #init(){
        new NumPlayersDialog("dialogDiv",(numberOfHumanPlayers) => {
            this.numberOfHumanPlayers=numberOfHumanPlayers;
            this.#connect4=new Connect4();
            this.#boardView = new BoardView(this.#connect4.getBoard());
            this.#turnView = new TurnView(this.#connect4.getTurn());
            this.#turnView.setNumberOfHumanPlayers(numberOfHumanPlayers);
            this.#turnView.renderTurn();
            this.#boardView.render();
            this.#turnView.getActivePlayer().accept(this); 
        });
    }

    #loadGame(game){
      this.#connect4=new Connect4();
      this.#connect4.fromJSON(game);
      this.#boardView = new BoardView(this.#connect4.getBoard());
      this.#turnView = new TurnView(this.#connect4.getTurn());
      this.#turnView.renderTurn();
      this.#boardView.render();
      this.#turnView.getActivePlayer().accept(this); 
    }

    #onUpdate(column) {
        assert(!this.#boardView.isWinner(),"Game is finished");
        
        this.#turnView.play(column);

        this.#storageView.render(this.#connect4);
        this.#turnView.renderTurn();
        this.#boardView.render();

        if (!this.#boardView.isFinished()) {
          this.#turnView.getActivePlayer().accept(this)
        } else {
          this.#turnView.renderResults()
          new ResumeDialog("dialogDiv",() => {
            this.clearDivs();
            this.#init();
          });
        }
      }
    clearDivs(){
      document.getElementById("infoDiv").innerHTML="";
      document.getElementById("infoDiv").style.display="none";
      document.getElementById("turnDiv").innerHTML="";
      const boardDiv=document.getElementById("boardDiv");
      boardDiv.removeChild(boardDiv.firstElementChild);
    }

    visitHumanPlayer() {
      this.#boardView.addUpdateListener(this.#onUpdate.bind(this));
    }
    visitRandomPlayer() {
        setTimeout(() => {
            this.#onUpdate()
          }, 300)
    }

}

window.onload = () => {
    new Connect4View();
}