package main.es.labturing.utils.framework;

public abstract class GameView<G> {

    protected G game;

    public GameView(G game) {
        this.game = game;
    }

    public abstract void start();

    public abstract void play();

    public abstract boolean resume();

}
