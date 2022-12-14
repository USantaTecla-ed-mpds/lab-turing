import { Player } from './Player.js';

export class MachinePlayer extends Player {

    constructor(color, board) {
        super(color, board);
    }

    accept(visitor){}
    
    getColumn(){}

}