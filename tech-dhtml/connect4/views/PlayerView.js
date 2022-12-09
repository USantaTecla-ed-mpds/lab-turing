import { ColorView } from './BoardView.js';
import { Message } from './Message.js';
//import { InIntervalDialog } from '../utils/views/Dialog.js';
import { Coordinate } from '../models/Board.js';

class PlayerView {
    #player;

    constructor(player) {
        this.#player = player;
    }

    writeWinner() {
        let turnViewDiv = document.getElementById("turnViewDiv");
        let message = Message.PLAYER_WIN.toString();
        message = message.replace(`#color`, new ColorView(this.#player.getColor()).toString());
        new Message(message).writeln(turnViewDiv);
    }

    getColumn() { }

    getPlayer() {
        return this.#player;
    }
}
class HumanPlayerView extends PlayerView {

    #buttonClicked = false;

    constructor(player) {
        super(player);
    }

    getColumn() {
        let column;

        //let buttonClicked = false;
        let turnViewDiv = document.getElementById("turnViewDiv");
        new Message(Message.TURN + new ColorView(super.getPlayer().getColor()).toString()).writeln(turnViewDiv);

        let message = document.createElement("p");
        message.innerHTML = Message.ENTER_COLUMN_TO_DROP.toString();
        let playerViewDiv = document.getElementById("playerViewDiv");
        playerViewDiv.innerHTML="";
        playerViewDiv.appendChild(message);
        let input = document.createElement("INPUT");
        input.setAttribute("type", "number");
        input.setAttribute("min", 1);
        input.setAttribute("max", Coordinate.NUMBER_COLUMNS);
        input.setAttribute("value", 3);
        playerViewDiv.appendChild(input);
        let button = document.createElement("BUTTON");
        const buttonText = document.createTextNode("Drop");
        button.appendChild(buttonText);
        playerViewDiv.appendChild(button);

        let valid;
        do {

            button.addEventListener("click", () => { this.setButtonClicked(); },false);
            console.log("Button clicked: " + this.#buttonClicked);
            /* do {
                      if (this.#buttonClicked) {
                          input.classList.remove("animated");
                          column = input.value - 1;
                          console.log('column selected: ' + input.value+1);
                          button.removeEventListener("click",()=>{this.setButtonClicked();});
                      }
                      else{
                        setTimeout(function(){
                            console.log("No se ha pulsado nada");
                        }, 2000);
                        
                        input.classList.add("animated");
                      }
            } while (!this.#buttonClicked);
            this.#buttonClicked = false;*/
            column = input.value - 1;
            console.log(column);
            valid = !super.getPlayer().isComplete(column);
            if (!valid) {
                // throw("completed")
                Message.COMPLETED_COLUMN.writeln(turnViewDiv);
                alert("Columna:" + column + ":" + Message.COMPLETED_COLUMN.toString());

            }
        } while (!valid);
        playerViewDiv.removeChild(message);
        playerViewDiv.removeChild(input);
        playerViewDiv.removeChild(button);
        return column;
    }

    setButtonClicked() {
        this.#buttonClicked = true;
        
        console.log("Click");

    }
}



class RandomPlayerView extends PlayerView {

    getColumn() {
        let turnViewDiv = document.getElementById("turnViewDiv");
        new Message(Message.TURN + new ColorView(super.getPlayer().getColor()).toString()).writeln(turnViewDiv);
        let column = this.getPlayer().getColumn();
        let playerViewDiv = document.getElementById("playerViewDiv");
        Message.RANDOM_COLUMN.writeln(playerViewDiv);
        new Message(Message.RANDOM_COLUMN + ":" + (column+1)).writeln(playerViewDiv);
        return column;
    }
}

export { HumanPlayerView, RandomPlayerView };