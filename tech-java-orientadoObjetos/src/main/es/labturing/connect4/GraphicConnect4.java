package main.es.labturing.connect4;

import main.es.labturing.connect4.views.graphic.GameView;

public class GraphicConnect4 extends Connect4 {

	@Override
	protected GameView createView() {
		return new GameView(this.startController, this.playController, this.resumeController, this.undoRedoController);
	}

	public static void main(String[] args) {
		new GraphicConnect4().play();
	}

}
