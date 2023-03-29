package connect4.models;

public class GameData {

    private Turn turn;
    private Board board;

    public Turn getTurn() {
        return this.turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
