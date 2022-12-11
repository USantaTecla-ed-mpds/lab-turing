import { Message } from './Message.js';
//import { InIntervalDialog } from '../utils/views/Dialog.js';
import { Coordinate } from '../models/Board.js';

class PlayerView {
    #player;

    constructor(player) {
        this.#player = player;
    }

    getColumn() { }

    getPlayer() {
        return this.#player;
    }
}
class HumanPlayerView extends PlayerView {
    #playerViewDiv;
    #buttonClicked;

    constructor(player) {
        super(player);
        this.#playerViewDiv = document.getElementById("playerViewDiv");
        for(child of this.#playerViewDiv.childNodes){
            this.#playerViewDiv.removeChild(child);
        } 
        this.#createDialog();
    }

    #createDialog(){
        let message = document.createElement("p");
        message.innerHTML = Message.ENTER_COLUMN_TO_DROP.toString();
        this.#playerViewDiv.innerHTML="";
        this.#playerViewDiv.appendChild(message);
        let input = document.createElement("INPUT");
        input.setAttribute("type", "number");
        input.setAttribute("min", 1);
        input.setAttribute("max", Coordinate.NUMBER_COLUMNS);
        input.setAttribute("value", 3);
        this.#playerViewDiv.appendChild(input);
        let button = document.createElement("BUTTON");
        const buttonText = document.createTextNode("Drop");
        button.appendChild(buttonText);
        this.#playerViewDiv.appendChild(button);
        button.addEventListener("click", () => { this.setButtonClicked(); });
    }

    getColumn() {
     /*   return new Promise((resolve)=>{

        });*/
        this.#buttonClicked = false;
        let column;
        let valid;
        do {
            console.log("Button clicked: " + this.#buttonClicked);
             do {
                      if (this.#buttonClicked) {
                          input.classList.remove("animated");
                          column = input.value - 1;
                          console.log('column selected: ' + input.value+1);
                          button.removeEventListener("click",()=>{this.setButtonClicked();});
                      }
                      else{
                      
                        input.classList.add("animated");
                      }
            } while (!this.#buttonClicked);
            this.#buttonClicked = false;
            column = input.value - 1;
            console.log(column);
            valid = !super.getPlayer().isComplete(column);
            if (!valid) {
                // throw("completed")
               // Message.COMPLETED_COLUMN.writeln(turnViewDiv);
                alert("Columna:" + column + ":" + Message.COMPLETED_COLUMN.toString());

            }
        } while (!valid);

        return column;
    }

    setButtonClicked() {
        this.#buttonClicked = true;
        console.log("Click");

    }
}



class RandomPlayerView extends PlayerView {

    #playerViewDiv;

    constructor(player) {
        super(player);
        this.#playerViewDiv = document.getElementById("playerViewDiv");
        for(child of this.#playerViewDiv.childNodes){
            this.#playerViewDiv.removeChild(child);
        } 
    }

    getColumn() {
       // return new Promise((resolve)=>{
       //     setTimeout(() => {
                let column = super.getPlayer().getColumn();
                new Message(Message.RANDOM_COLUMN + ":" + (column+1)).writeln(this.#playerViewDiv);
                return column;
       //     }, Math.random() * 2000 + 1000);
      //  });  
    }
}

export { HumanPlayerView, RandomPlayerView };