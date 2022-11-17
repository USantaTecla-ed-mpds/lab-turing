import { Message } from './views/Message.js';
import { YesNoDialog }  from './utils/views/Dialog.js';
import { Board } from './models/Board.js';
import { Turn } from './models/Turn.js';
import { BoardView } from './views/BoardView.js';
import { TurnView } from './views/TurnView.js';

class Connect4 {
    #board;
    #turn;
    #boardView;
    #turnView;

    constructor() {
        this.#board = new Board();
        this.#boardView = new BoardView(this.#board);
        this.#turn = new Turn(this.#board);
        this.#turnView = new TurnView(this.#turn);
    }

    playGames() {
        do {
            this.#playGame();
        } while (this.#isResumed());
    }

    #playGame() {
        this.#turnView.setNumberOfHumanPlayers();
        Message.TITLE.writeln();
        this.#boardView.writeln();

        do {
            this.#turnView.play();
            this.#boardView.writeln();
        } while (!this.#board.isFinished());
        this.#turnView.writeResult();
    }

    #isResumed() {
        let yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.#board.reset();
        }
        return yesNoDialog.isAffirmative();
    }
}
new Connect4().playGames();
