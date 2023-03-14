package main.es.pbover.connect4.models;

public class Color {
    static RED = new Color(`Red`);
    static YELLOW = new Color(`Yellow`);
    static NULL = new Color(`White`);
    #string;

    constructor(string) {
        this.#string = string;
    }

    static get(ordinal) {
        return Color.#values()[ordinal];
    }

    static #values() {
        return [Color.RED, Color.YELLOW, Color.NULL];
    }

    getString() {
        return this.#string;
    }
    
    static PLAYERS = [Color.RED, Color.YELLOW];

    getOpposite() {
        return Color.#values()[(this.ordinal() + 1) % Color.PLAYERS.length];
    }

    ordinal() {
        for(let i = 0; i < Color.PLAYERS.length; i++){
            if (this == Color.PLAYERS[i]){
                return i;
            }
        }
        return -1;
    }

    getCode() {
        if (this == Color.NULL) {
            return ' ';
        }
        return this.toString().charAt(0);
    } 
}
