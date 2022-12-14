export class MessageDialog {

    #board
    #article

    constructor(board) {
        this.#board = board
        this.#article = document.getElementById('messageId')
        this.#article.innerHTML = ''
    }

    update() {
        let message = 'Tied!'
        if (this.#board.isWinner()) {
            const color = this.#board.getColor(this.#board.getLastDrop())
            message = `<b style='color: ${color}'>${color}</b> Has won the game!`
        }
        this.#article.innerHTML = message;
    }

}
