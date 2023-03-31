package main.es.pbover.parametrizado;

public abstract class GenericGameView<G> {

    private G game;

    public  GenericGameView(G game){
        this.game= game;
    }

    public abstract void start();
    public abstract void play();
    public abstract boolean resume();

}
