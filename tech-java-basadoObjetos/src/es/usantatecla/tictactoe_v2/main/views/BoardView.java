package es.usantatecla.tictactoe_v2.main.views;

import es.usantatecla.tictactoe_v2.utils.Console;

class BoardView {

	private Board board;

	public BoardView(Board board) {
		this.board = board;
	}


	public void write() {
		Message.HORIZONTAL_LINE.writeln();
		for (int i = 0; i < Coordinate.getDimension(); i++) {
			Message.VERTICAL_LINE.write();
			for (int j = 0; j < Coordinate.getDimension(); j++) {
				this.getColor(new Coordinate(i, j)).write();
				Message.VERTICAL_LINE.write();
			}
			Console.getInstance().writeln();
		}
		Message.HORIZONTAL_LINE.writeln();
	}

}

