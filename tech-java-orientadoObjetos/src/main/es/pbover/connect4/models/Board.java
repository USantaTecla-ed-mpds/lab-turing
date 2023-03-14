package main.es.pbover.connect4.models;

public class Board {

    public static final int LINE_LENGTH = 4;
    private Color[][] colors;
    private Coordinate lastDrop;

    public Board() {
        this.colors = new Color[Coordinate.DIMENSION][Coordinate.DIMENSION];
        this.reset();
    }

    public void reset() {
        for (int i = 0; i < Coordinate.NUMBER_ROWS; i++) {
            for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    public void dropToken(int column, Color color) {
        this.lastDrop = new Coordinate(0, column);
        while (!this.isEmpty(this.lastDrop)) {
            this.lastDrop = this.lastDrop.shifted(Direction.NORTH.getCoordinate());
        }
        this.colors[this.lastDrop.getRow()][this.lastDrop.getColumn()] = color;
    }

    public void isComplete(int column) {
        if (column != null) {
            return !this.isEmpty(new Coordinate(Coordinate.NUMBER_ROWS - 1, column));
        }
        for (int i = 0; i < Coordinate.NUMBER_COLUMNS; i++) {
            if (!this.isComplete(i)) {
                return false;
            }
        }
        return true;
    }

    public void isFinished() {
        return this.isComplete() || this.isWinner();
    }

    public void isWinner() {
            if (this.lastDrop == null) {
                return false;
            }
            for (let direction of Direction.halfValues()) {
                LINE line = [this.lastDrop];
                this.#setLine(line, direction);
                for (int i = 1; i < Board.LINE_LENGTH; i++) {
                    line[i] = line[i - 1].shifted(direction.getCoordinate());
                }
                for (let i = 0; i < Board.LINE_LENGTH; i++) {
                    if (this.#isConnect4(line)) {
                        return true;
                    }
                    this.#shiftLine(line, direction);
                }
            }
            return false;
        }

    #setLine(line, direction) {
            for (let i = 1; i < Board.LINE_LENGTH; i++) {
                line[i] = line[i - 1].shifted(direction.getCoordinate());
            }
        }
        #shiftLine(line, direction) {
            let oppositeDirection = direction.getOpposite();
            for (let j = 0; j < Board.LINE_LENGTH; j++) {
                line[j] = line[j].shifted(oppositeDirection.getCoordinate());
            }
        }
    
        #isConnect4(line) {
            for (let i = 0; i < Board.LINE_LENGTH; i++) {
                if (!line[i].isValid()) {
                    return false;
                }
                if (i > 0 && this.getColor(line[i - 1]) != this.getColor(line[i])) {
                    return false;
                }
            }
            return true;
        }

    isAlmostWinner() {
            if (this.#lastDrop === undefined) {
                return false;
            }
            for (let direction of Direction.halfValues()) {
                let line = [this.#lastDrop];
                this.#set3Line(line, direction);
                for (let i = 1; i < Board.LINE_LENGTH-1; i++) {
                    line[i] = line[i - 1].shifted(direction.getCoordinate());
                }
                for (let i = 0; i < Board.LINE_LENGTH-1; i++) {
                    if (this.#isConnect3(line)) {
                        return true;
                    }
                    this.#shift3Line(line, direction);
                }
            }
            return false;
        }#set3Line(line, direction) {
            for (let i = 1; i < Board.LINE_LENGTH-1; i++) {
                line[i] = line[i - 1].shifted(direction.getCoordinate());
            }
        }
        #shift3Line(line, direction) {
            let oppositeDirection = direction.getOpposite();
            for (let j = 0; j < Board.LINE_LENGTH-1; j++) {
                line[j] = line[j].shifted(oppositeDirection.getCoordinate());
            }
        }
    
        #isConnect3(line) {
            for (let i = 0; i < Board.LINE_LENGTH-1; i++) {
                if (!line[i].isValid()) {
                    return false;
                }
                if (i > 0 && this.getColor(line[i - 1]) != this.getColor(line[i])) {
                    return false;
                }
            }
            return true;
        }
    
        isOccupied(coordinate, color) {
            return this.getColor(coordinate) === color;
        }
    
        isEmpty(coordinate) {
            return this.isOccupied(coordinate, Color.NULL);
        }
    
        getColor(coordinate) {
            return this.#colors[coordinate.getRow()][coordinate.getColumn()];
        }
        setColor(coordinate, color) {
            this.#colors[coordinate.getRow()][coordinate.getColumn()] = color;
        }

    getUncompletedColumns() {
            let uncompletedColumns = [];
            for (let j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                if (!this.isComplete(j)) {
                    uncompletedColumns.push(j);
                }
            }
            return uncompletedColumns;
        }

    removeTop(column) {
            this.setColor(this.getTop(column), Color.NULL);
        }
    
        getTop(column) {
            let coordinate = new Coordinate(Coordinate.NUMBER_ROWS - 1, column);
            while (this.isEmpty(coordinate)) {
                coordinate = Direction.SOUTH.next(coordinate);
            }
            return coordinate;
        }
    
        isEmpty(value) {
            if (value != undefined){
                if (typeof value == "number"){
                    return this.isEmpty(new Coordinate(0, value));
                } 
                return this.isOccupied(value, Color.NULL);
            }
            for (let i = 0; i < Coordinate.NUMBER_COLUMNS; i++) {
                if (!this.isEmpty(i)) {
                    return false;
                }
            }
            return true;
        }
    

}
