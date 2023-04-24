package main.es.labturing.utils.framework;

public abstract class GameView<S, P, R> {

    protected S startController;
    protected P playController;
    protected R resumeController;

    public GameView(S startController, P playController, R resumeController) {
        this.startController = startController;
        this.playController = playController;
        this.resumeController = resumeController;
    }

    public abstract void start();

    public abstract void play();

    public abstract boolean resume();

}
