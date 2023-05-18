package main.es.labturing.connect4;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.ResumeController;
import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.views.console.GameView;

public class ConsoleConnect4 extends Connect4 {

	@Override
	protected GameView createView() {
		return new GameView();
	}

	public static void main(String[] args) {
		new ConsoleConnect4().interact();
	}

}
