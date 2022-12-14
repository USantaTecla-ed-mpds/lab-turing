import { ButtonsDialog } from './ButtonsDialog.js'

export class ResumeDialog extends ButtonsDialog {

    constructor(callback) {
        super()
        this.createButtons()
        this.addButton('Play again!', callback)
    }
}