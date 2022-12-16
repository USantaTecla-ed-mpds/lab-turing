class ButtonsDialog {
    
    #buttons;
    #divElement;

    constructor(divElement){
        this.#divElement=divElement;
    }

    createButtonsContainer(title ="") {
        this.#buttons = document.createElement('div');
        this.#buttons.id = 'buttonsId';
        const titleH3=document.createElement('h3');
        titleH3.innerHTML=title;
        document.getElementById(this.#divElement).append(titleH3,this.#buttons);
        document.getElementById(this.#divElement).style.display="block";
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
        let childs=document.getElementById(this.#divElement)
        while(childs.firstChild){
            childs.removeChild(childs.firstChild);
        }
        document.getElementById(this.#divElement).style.display="none";
    }

    getButtons(){
        return this.#buttons;
    }

}

class NumPlayersDialog extends ButtonsDialog {

    constructor(divElement,callback) {
        super(divElement);
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

    constructor(divElement,callback) {
        super(divElement)
        this.createButtonsContainer()
        this.addButton('Play again!', callback)
    }
}

class StorageDialog extends ButtonsDialog {

    constructor(divElement,savecallback,loadcallback) {
        super(divElement);
        this.deleteDialog();
        this.createButtonsContainer("LocalStorage : ");
        this.addButton("Save", savecallback);
        this.addButton("Load", loadcallback);
    }
}

export {NumPlayersDialog, ResumeDialog, StorageDialog};