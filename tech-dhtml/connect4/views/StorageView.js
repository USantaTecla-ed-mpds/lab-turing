import { StorageDialog } from "../utils/views/Dialog.js";
import { Connect4LocalStorage } from "./Connect4LocalStorage.js";

export class StorageView {
    #connect4LocalStorage;
    #loadGameCallback

    constructor(loadGameCallback) {
        this.#connect4LocalStorage = new Connect4LocalStorage();
        this.#loadGameCallback=loadGameCallback;
        this.render();
    }

    render(connect4) {
        if(connect4){
            new StorageDialog(() => this.#connect4LocalStorage.saveGame(connect4));
        }
        this.#renderSavedGames();

    }

    #renderSavedGames() {
        document.getElementById("StorageDiv").innerHTML = "";
        document.getElementById("StorageDiv").append(this.#createSelect());
    }

    #createSelect() {
        let select = document.createElement('select');
        this.#connect4LocalStorage.getKeysOfSavedGames().forEach((key) => {
            let option = document.createElement('option');
            option.setAttribute("value", key)
            option.innerHTML = key;
            select.append(option);
            select.onchange = () => {
                this.#loadGameCallback(this.#connect4LocalStorage.loadGameByKey(key));
            }
        });
        return select;
    }

}