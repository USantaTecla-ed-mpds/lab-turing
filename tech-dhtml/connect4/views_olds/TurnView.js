import { PlayerVisitor } from '../models/Player.js';
import { HumanPlayerView, RandomPlayerView } from './PlayerView.js';
//import { InIntervalDialog } from '../utils/views/Dialog.js';
import { Message } from './Message.js';
import { ColorView } from './BoardView.js';


class TurnView extends PlayerVisitor {
    #turn;
    #activePlayerView;
    #turnViewDiv;

    constructor(turn) {
        super();
        this.#turn = turn;
        this.#turnViewDiv=document.getElementById("turnViewDiv");
    }
    setNumberOfHumanPlayers() {
        /*  let inIntervalDialog = new InIntervalDialog(0, this.#turn.getNumberPlayers());
          inIntervalDialog.read(Message.NUM_PLAYERS.toString());*/

        this.#turn.reset(0); /*inIntervalDialog.getAnswer()*/
    }

    async play() {
        this.#turn.getActivePlayer().accept(this);
        this.write();
        this.#turn.play(await this.#activePlayerView.getColumn());
    }

    write(){
         new Message(Message.TURN + new ColorView(this.#activePlayerView.getPlayer().getColor()).toString()).writeln(this.#turnViewDiv);
    }

    writeResult() {
        if ((this.#turn.getBoard()).isWinner()) {
            this.writeWinner();
        } else {
            Message.PLAYERS_TIED.writeln(this.#turnViewDiv);
        }
    }

    writeWinner() {
        let message = Message.PLAYER_WIN.toString();
        message = message.replace(`#color`, new ColorView(this.#turn.getActivePlayer().getColor()).toString());
        new Message(message).writeln(this.#turnViewDiv);
    }

    

    visitHumanPlayer(humanPlayer) {
        this.#activePlayerView = new HumanPlayerView(humanPlayer);
    }
    visitRandomPlayer(randomPlayer) {
        this.#activePlayerView = new RandomPlayerView(randomPlayer);
    }
}

export { TurnView }