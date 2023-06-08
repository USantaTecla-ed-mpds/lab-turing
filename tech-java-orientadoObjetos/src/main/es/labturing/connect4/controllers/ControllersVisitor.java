package main.es.labturing.connect4.controllers;

public interface ControllersVisitor {

	public void visit(StartController startController);

	public void visit(PlayController playController);

	public void visit(SaveController saveController);

	public void visit(ResumeController resumeController);

}
