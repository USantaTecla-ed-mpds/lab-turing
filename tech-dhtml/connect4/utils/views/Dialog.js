class ButtonsDialog {
    
    #buttons

    createButtonsContainer(title ="") {
        this.#buttons = document.createElement('div');
        this.#buttons.id = 'buttonsId';
        const titleH3=document.createElement('h3');
        titleH3.innerHTML=title;
        document.getElementById('dialogDiv').append(titleH3,this.#buttons);
    }

    addButton(text, callback, index) {
        let button = document.createElement('button');
        this.getButtons().append(button);
        button.innerText = text;
        button.addEventListener('click', () => {
            this.deleteDialog();
            callback(index);
        });
    }

    deleteDialog() {
        let childs=document.getElementById('dialogDiv')
        while(childs.firstChild){
            childs.removeChild(childs.firstChild);
        }
    }

    getButtons(){
        return this.#buttons;
    }

}

class NumPlayersDialog extends ButtonsDialog {

    constructor(callback) {
        super();
        this.createButtonsContainer("Select Game Mode: ");
        let texts = [
            `Machine VS Machine`,
            `Player VS Machine`,
            `Player VS Player`];
        for (let i = 0; i < texts.length; i++) {
            this.addButton(texts[i], callback, i);
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

class StorageDialog extends ButtonsDialog {

    constructor(savecallback) {
        super();
        this.deleteDialog();
        this.createButtonsContainer("LocalStorage : ");
        this.addButton("Save", savecallback);
    }
}

export {NumPlayersDialog, ResumeDialog, StorageDialog};