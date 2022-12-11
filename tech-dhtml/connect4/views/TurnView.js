import { Coordinate } from '../models/Board.js';
export class TurnView {
    #turn;
    #turnViewDiv;

    constructor(turn) {
        this.#turn = turn;
        this.#turnViewDiv = document.getElementById("turnViewDiv");
        this.#turnViewDiv.innerHTML = "";
    }

    setNumberOfHumanPlayers(numberOfHumanPlayers) {
        this.renderControlsNumberOfPlayer();
        this.#turn.reset(numberOfHumanPlayers);
        this.render();
    }

    render() {
        this.#turnViewDiv.innerHTML = `Turn: ${this.getActivePlayer().getColor().getString()}`;
    }

    getActivePlayer() {
        return this.#turn.getActivePlayer();
    }

    isValidColumn(column) {
        if (this.getActivePlayer().isComplete(column)) {
            this.#turnViewDiv.innerHTML = ` Invalid column!!! ${column} 's completed`;
            return false;
        }
        return true;
    }

    play(column) {
        this.#turn.play(column);
        this.render();

    }

    writeResult() {
        if ((this.#turn.getBoard()).isWinner()) {
            this.#turnViewDiv.innerHTML = `${this.getActivePlayer().getColor().getString()}s WIN!!! : -)`;
        } else {
            this.#turnViewDiv.innerHTML = `TIED!!!`;
        }
    }

    renderTurnControls(that) {
        
        const playerViewDiv = document.getElementById("playerViewDiv");
        playerViewDiv.innerHTML = "";

        let message = document.createElement("p");
        message.innerHTML = `Enter a column to drop a token: `;
        playerViewDiv.append(message);
        let input = document.createElement("INPUT");
        input.setAttribute("type", "number");
        input.setAttribute("min", 1);
        input.setAttribute("max", Coordinate.NUMBER_COLUMNS);
        playerViewDiv.append(input);

        let button = document.createElement("BUTTON");
        button.innerText = "Drop";
        playerViewDiv.append(button);

        button.addEventListener("click", () => {
            if (!Number.isNaN(input.value) && 0 < input.value && input.value < Coordinate.NUMBER_COLUMNS + 1) {
                if (this.isValidColumn(input.value - 1)) {
                    
                    that.play(input.value - 1);
                   // playerViewDiv.innerHTML = "";
                }
            }
            else {
                this.#turnViewDiv.innerHTML = ` Invalid column!!!`;
            }

        });
    }

    renderControlsNumberOfPlayer(that) {
        const playerViewDiv = document.getElementById("playerViewDiv");
        let message = document.createElement("p");
        message.innerHTML = `Enter number of human players: `;
        playerViewDiv.innerHTML = "";
        playerViewDiv.append(message);

        let input = document.createElement("INPUT");
        input.setAttribute("type", "number");
        input.setAttribute("min", 0);
        input.setAttribute("max",  this.#turn.getNumberPlayers());
        playerViewDiv.append(input);

        let button = document.createElement("BUTTON");
        button.innerText = "Select";
        playerViewDiv.append(button);

        button.addEventListener("click", () => {
            if (!Number.isNaN(input.value) && 0 <= input.value && input.value < this.#turn.getNumberPlayers()+1) {
                that.playGame(input.value);
            }
            else {
                this.#turnViewDiv.innerHTML = ` Invalid number of players[0-2]!!!`;
            }

        });
        
    }

    renderControlsPlayAgain(that) {
        const playerViewDiv = document.getElementById("playerViewDiv");
        playerViewDiv.innerHTML = "";

        let message = document.createElement("p");
        message.innerHTML = `Do you want to continue (y/n)`;
        message.setAttribute("translate","no");
        playerViewDiv.append(message);

        let button = document.createElement("BUTTON");
        button.innerText = "Continue?";
        playerViewDiv.append(button);

        let input = document.createElement("INPUT");
        input.setAttribute("type", "text");
        playerViewDiv.append(input);


        button.addEventListener("click", () => {
            if ( input.value==='y') {
                this.#turn.getBoard().reset();
                that.askHumanPlayers();
            }
            else {
                this.#turnViewDiv.innerHTML = ` Type y to continue!!!`;
            }

        });
        
    }


}