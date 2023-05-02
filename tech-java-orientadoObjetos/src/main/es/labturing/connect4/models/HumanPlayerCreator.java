package main.es.labturing.connect4.models;

public class HumanPlayerCreator implements PlayerCreator {

    @Override
    public HumanPlayer create(Board board) {
        return new HumanPlayer(board);
    }

}
