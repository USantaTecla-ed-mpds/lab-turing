package main.es.labturing.connect4.models;

public class RandomPlayerCreator implements PlayerCreator {

    @Override
    public RandomPlayer create(Board board) {
        return new RandomPlayer(board);
    }

}
