package main.es.labturing.connect4.views;

import main.es.labturing.connect4.controllers.ControllersVisitor;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.ResumeController;
import main.es.labturing.connect4.controllers.SaveController;
import main.es.labturing.connect4.controllers.StartController;

public abstract class GameView implements ControllersVisitor {

    protected abstract void start(StartController startController);

    protected abstract void play(PlayController playController);

    protected abstract void saveAndOrExit(SaveController saveController);

    protected abstract void resume(ResumeController resumeController);
    
    @Override
    public void visit(StartController startController) {
        this.start(startController);

    }

    @Override
    public void visit(PlayController playController) {
        this.play(playController);
    }

    @Override
    public void visit(SaveController saveController) {
        this.saveAndOrExit(saveController);
    }

    @Override
    public void visit(ResumeController resumeController) {
        this.resume(resumeController);
    }
}
