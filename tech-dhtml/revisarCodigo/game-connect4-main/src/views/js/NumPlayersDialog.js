import { ButtonsDialog } from './ButtonsDialog.js'

export class NumPlayersDialog extends ButtonsDialog {

    constructor(callback) {
        super()
        this.createButtons();
        let texts = [
            `Machine VS Machine`,
            `Player VS Machine`,
            `Player VS Player`]
        for (let i = 0; i < texts.length; i++) {
            this.addButton(texts[i], callback, i)
        }
    }

}