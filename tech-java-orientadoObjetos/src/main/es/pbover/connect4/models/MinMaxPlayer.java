package main.es.pbover.connect4.models;

public class MinMaxPlayer {
    #maxSteps;
    static #MAX_COST = 2;
    static #OTHER_COST = 0;
    static #MIN_COST = -2;
    //flagColumn = false;

    constructor(color, board ,maxSteps) {
        super(color, board);
        this.#maxSteps=maxSteps;
    }

    getColumn() {
        let uncompletedColumns = this.getBoard().getUncompletedColumns();
        let bestColumn = uncompletedColumns[ Math.floor(Math.random() * uncompletedColumns.length)];
        let maxCost = MinMaxPlayer.#MIN_COST;
        for (let column of uncompletedColumns) {
            this.getBoard().dropToken(column, this.getColor());
            let minCost = this.#getMinCost(0);
            this.getBoard().removeTop(column);
            if (minCost > maxCost) {
                maxCost = minCost;
                bestColumn = column;
            }
        }
     //   console.writeln(`Inteligentemente en la columna: ${bestColumn}`);
        //Evento columna seleccionada
        return bestColumn;
    }

    #getMinCost(steps) {
        if (this.#isEnd(steps)) {
            return this.#getCost(false);
        }
        let minCost = MinMaxPlayer.#MAX_COST;
        for (let column of this.getBoard().getUncompletedColumns()) {
            this.getBoard().dropToken(column, this.getColor().getOpposite());
            let maxCost = this.#getMaxCost(steps + 1);
            this.getBoard().removeTop(column);
            if (maxCost < minCost)
                minCost = maxCost;
        }
        return minCost;
    }

    #getMaxCost(steps) {
        if (this.#isEnd(steps)) {
            return this.#getCost(true);
        }
        let maxCost = MinMaxPlayer.#MIN_COST;
        for (let column of this.getBoard().getUncompletedColumns()) {
            this.getBoard().dropToken(column, this.getColor());
            let cost = this.#getMinCost(steps + 1);
            this.getBoard().removeTop(column);
            if (cost > maxCost)
                maxCost = cost;
        }
        return maxCost;
    }

    #isEnd(steps) {
        return steps == this.#maxSteps || this.getBoard().isFinished();
    }

    #getCost(isOpposite) {
        if (this.getBoard().isWinner()) { 
          if (isOpposite){
            return MinMaxPlayer.#MIN_COST; 
          }
          else  { 
           return MinMaxPlayer.#MAX_COST;
          }
        }
        if (this.getBoard().isAlmostWinner()) {
          if (isOpposite){
            return MinMaxPlayer.#MIN_COST/2; 
          }
          else  { 
           return MinMaxPlayer.#MAX_COST/2;
          }
        }
        return MinMaxPlayer.#OTHER_COST;
    }
    
    accept(visitor) {
       // this.flagColumn= false;
        visitor.visitMinMaxPlayer(this);
    }
}
