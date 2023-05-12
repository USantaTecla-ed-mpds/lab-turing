package main.es.labturing.connect4.views;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.ResumeController;
import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.controllers.UndoRedoController;

public abstract class View {

    protected StartController startController;
    protected PlayController playController;
    protected ResumeController resumeController;
    protected UndoRedoController undoRedoController;  

    public View(StartController startController, PlayController playController, ResumeController resumeController, UndoRedoController undoRedoController){
        this.startController = startController;
        this.playController = playController;
        this.resumeController = resumeController;
        this.undoRedoController = undoRedoController;
    }
    
    public abstract void start();

    public abstract void play();

    public abstract boolean resume();
    
}
