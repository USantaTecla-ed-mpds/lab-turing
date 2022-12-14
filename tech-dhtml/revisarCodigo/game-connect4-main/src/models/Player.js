export class Player {
    
    #color;
    #board;

    constructor(color, board) {
        this.#color = color;
        this.#board = board;        
    }

    getColor(){
        return this.#color;
    }

    isComplete(column){
        return this.#board.isComplete(column);
    }

    dropToken(column){
        this.#board.dropToken(column, this.#color);
    }

    accept(visitor){}

}