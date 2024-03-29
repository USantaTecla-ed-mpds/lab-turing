import { PlayerVisitor } from '../models/Player.js';
import { HumanPlayerView, RandomPlayerView } from './PlayerView.js';
import { InIntervalDialog } from '../utils/views/Dialog.js';
import { Message } from './Message.js';



class TurnView extends PlayerVisitor {
    #turn;
    #activePlayerView;

    constructor(turn) {
        super();
        this.#turn = turn;
    }
    setNumberOfHumanPlayers() { 
        let inIntervalDialog = new InIntervalDialog(0, this.#turn.getNumberPlayers());
        inIntervalDialog.read(Message.NUM_PLAYERS.toString());
        this.#turn.reset(inIntervalDialog.getAnswer());
    }

    play() {
        this.#turn.getActivePlayer().accept(this);
        this.#turn.play(this.#activePlayerView.getColumn());
    }

    writeResult() {
        if ((this.#turn.getBoard()).isWinner()) {
            this.#activePlayerView.writeWinner();
        } else {
            Message.PLAYERS_TIED.writeln();
        }
    }
    visitHumanPlayer(humanPlayer) {
        this.#activePlayerView = new HumanPlayerView(humanPlayer);
    }
    visitRandomPlayer(randomPlayer) {
        this.#activePlayerView = new RandomPlayerView(randomPlayer);
    }
}

export { TurnView }