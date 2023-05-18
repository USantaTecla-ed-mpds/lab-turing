package main.es.labturing.utils.framework;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.ResumeController;
import main.es.labturing.connect4.controllers.StartController;

public interface ControllersVisitor {

    void visit(StartController startController);
	void visit(PlayController playController);
	boolean visit(ResumeController resumeController);
    
}
