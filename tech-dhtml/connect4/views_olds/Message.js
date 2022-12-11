export class Message {
    static TITLE = new Message(`--- CONNECT 4 ---`);
    static NUM_PLAYERS = new Message(`Enter number of human players: `);
    static HORIZONTAL_LINE = new Message(`-`);
    static VERTICAL_LINE = new Message(`|`);
    static TURN = new Message(`Turn: `);
    static ENTER_COLUMN_TO_DROP = new Message(`Enter a column to drop a token: `);
    static INVALID_COLUMN = new Message(`Invalid columnn!!! Values [1-7]`);
    static COMPLETED_COLUMN = new Message(`Invalid column!!! It's completed`);
    static RANDOM_COLUMN = new Message(`Choosed radom column: `);
    static PLAYER_WIN = new Message(`#colorS WIN!!! : -)`);
    static PLAYERS_TIED = new Message(`TIED!!!`);
    static RESUME = new Message(`Do you want to continue`);

    #string;

    constructor(string) {
        this.#string = string;
    }

    writeln(element) {
        element.innerHTML = this.#string; 
    }

    toString() {
        return this.#string;
    }

}