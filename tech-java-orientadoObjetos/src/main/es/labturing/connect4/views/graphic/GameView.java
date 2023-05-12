package main.es.labturing.connect4.views.graphic;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.ResumeController;
import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.controllers.UndoRedoController;

import main.es.labturing.connect4.views.View;

public class GameView extends View{

    private StartView startView;
    
    public GameView(StartController startController, PlayController playController, ResumeController resumeController, UndoRedoController undoRedoController){
        super(startController, playController, resumeController, undoRedoController); 
        this.startView = new StartView(startController); 
    }
    
    @Override
    public void start(){
        this.startView.interact();
        System.out.println("traza start");
    }


    @Override
    public void play() {
        System.out.println("traza play");

    }

    @Override
    public boolean resume() {
        System.out.println("traza resume");
        return true;
    }
}
