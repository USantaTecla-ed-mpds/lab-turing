package main.es.labturing.utils.framework;

public interface ControllersVisitor {

	void visit(StartController startController);

	void visit(PlayController playController);

	boolean visit(ResumeController resumeController);

}
