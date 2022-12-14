import { Player } from './Player.js';

export class UserPlayer extends Player {
    
    constructor(color, board) {
        super(color, board);
    }

    accept(visitor){
        visitor.visitUserPlayer(this);
    }

}