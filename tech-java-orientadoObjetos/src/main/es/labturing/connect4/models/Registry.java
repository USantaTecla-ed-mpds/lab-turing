package main.es.labturing.connect4.models;

import java.util.List;
import java.util.ArrayList;

public class Registry {

    private Game game;
    private List<GameState> gameStates;
    private int firstPrevious;

    public Registry(Game game) {
        this.game = game;
        this.reset();
    }

    public void reset() {
        this.firstPrevious = 0;
        this.gameStates = new ArrayList<GameState>();
        this.gameStates.add(this.firstPrevious,game.getState());
    }

    public void registry(Game game) {
        for (int i = 0; i < this.firstPrevious; i++) {
            this.gameStates.remove(0);
        }
        this.firstPrevious = 0;
        this.gameStates.add(this.firstPrevious, game.getState());

    }

    public GameState getUndoneState() {
        this.firstPrevious++;
        return this.gameStates.get(firstPrevious).clone();
    }

    public GameState getRedoneState() {
        this.firstPrevious--;
        return this.gameStates.get(firstPrevious).clone();

    }

    public boolean isUndoable() {
        return this.firstPrevious < this.gameStates.size() - 1;
    }

    public boolean isRedoable() {
        return this.firstPrevious >= 1;
    }

    public GameState getLastGameState(){
        return this.gameStates.get(this.firstPrevious).clone();
    }
}
