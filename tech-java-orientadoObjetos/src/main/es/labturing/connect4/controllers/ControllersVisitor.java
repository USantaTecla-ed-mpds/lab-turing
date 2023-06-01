package main.es.labturing.connect4.controllers;

public abstract class ControllersVisitor {

	public abstract void visit(StartController startController);

	public abstract void visit(PlayController playController);
	
	public abstract void visit(SaveController saveController);

	public abstract void visit(ResumeController resumeController);

}
