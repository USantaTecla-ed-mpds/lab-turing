package main.es.labturing.utils.framework;

public abstract class GameView<S, P, R, U> {

    protected S startController;
    protected P playController;
    protected R resumeController;
    protected U undoRedoController;

    public GameView(S startController, P playController, R resumeController, U undoRedoController) {
        this.startController = startController;
        this.playController = playController;
        this.resumeController = resumeController;
        this.undoRedoController = undoRedoController;
    }

    public abstract void start();

    public abstract void play();

    public abstract boolean resume();

}
