export class ButtonsDialog {
    
    #buttons

    createButtons() {
        this.#buttons = document.createElement('div')
        this.#buttons.id = 'buttonsId'
        document.getElementById('leftPanel').append(this.#buttons)
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