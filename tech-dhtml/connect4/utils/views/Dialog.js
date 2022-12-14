class ButtonsDialog {
    
    #buttons

    createButtonsContainer() {
        this.#buttons = document.createElement('div')
        this.#buttons.id = 'buttonsId'
        document.getElementById('dialogDiv').append(this.#buttons)
    }

    addButton(text, callback, index) {
        let button = document.createElement('button')
        this.getButtons().append(button)
        button.innerText = text
        button.addEventListener('click', () => {
            this.deleteButtons()
            callback(index)
        })
    }

    deleteButtons() {
        document.getElementById('buttonsId').remove()
    }

    getButtons(){
        return this.#buttons;
    }

}

class NumPlayersDialog extends ButtonsDialog {

    constructor(callback) {
        super()
        this.createButtonsContainer();
        let texts = [
            `Machine VS Machine`,
            `Player VS Machine`,
            `Player VS Player`]
        for (let i = 0; i < texts.length; i++) {
            this.addButton(texts[i], callback, i)
        }
    }

}

class ResumeDialog extends ButtonsDialog {

    constructor(callback) {
        super()
        this.createButtonsContainer()
        this.addButton('Play again!', callback)
    }
}

export {NumPlayersDialog, ResumeDialog};