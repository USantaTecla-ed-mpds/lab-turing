package main.es.labturing.connect4.models;

public class MinMaxPlayerCreator implements PlayerCreator {

    @Override
    public MinMaxPlayer create(Board board) {
        return new MinMaxPlayer(board);
    }
}
