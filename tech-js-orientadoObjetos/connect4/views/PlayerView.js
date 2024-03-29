import { ColorView } from './BoardView.js';
import { Message } from './Message.js';
import { InIntervalDialog } from '../utils/views/Dialog.js';
import { Coordinate } from '../models/Board.js';

class PlayerView {
    #player;

    constructor(player) {
        this.#player = player;
    }

    writeWinner() {
        let message = Message.PLAYER_WIN.toString();
        message = message.replace(`#color`, new ColorView(this.#player.getColor()).toString());
        new Message(message).writeln();
    }

    getColumn() { }

    getPlayer() {
        return this.#player;
    }
}
class HumanPlayerView extends PlayerView {

    constructor(player) {
        super(player);
    }

    getColumn() {
        let column;
        let valid;
        do {
            Message.TURN.write();
            new Message(new ColorView(super.getPlayer().getColor()).toString()).writeln();
            let inIntervalDialog = new InIntervalDialog(1,Coordinate.NUMBER_COLUMNS);
            inIntervalDialog.read(Message.ENTER_COLUMN_TO_DROP.toString());
            column = inIntervalDialog.getAnswer()-1;
            valid = !super.getPlayer().isComplete(column);
            if (!valid) {
                Message.COMPLETED_COLUMN.writeln();
            }
        } while (!valid);
        return column;
    }
}
class RandomPlayerView extends PlayerView {

    getColumn() {
        Message.TURN.write();
        new Message(new ColorView(super.getPlayer().getColor()).toString()).writeln();
        let column = this.getPlayer().getColumn();
        Message.RANDOM_COLUMN.write();
        new Message(column + 1).writeln();
        return column;
    }
}

export { HumanPlayerView, RandomPlayerView };