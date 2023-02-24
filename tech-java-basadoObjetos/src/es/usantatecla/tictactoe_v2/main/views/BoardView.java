package es.usantatecla.tictactoe_v2.main.views;

import es.usantatecla.tictactoe_v2.main.models.Board;
import es.usantatecla.tictactoe_v2.main.models.BoundedCoordinate;
import es.usantatecla.tictactoe_v2.main.models.Message;
import es.usantatecla.tictactoe_v2.utils.Console;

public class BoardView {

	private Board board;

	public BoardView(Board board) {
		this.board = board;
	}


	public void write() {
		new MessageView(Message.HORIZONTAL_LINE).writeln();
		for (int i = 0; i < BoundedCoordinate.getDimension(); i++) {
			new MessageView(Message.VERTICAL_LINE).write();
			for (int j = 0; j < BoundedCoordinate.getDimension(); j++) {
				new ColorView(this.board.getColor(new BoundedCoordinate(i, j))).write();
				new MessageView(Message.VERTICAL_LINE).write();
			}
			Console.getInstance().writeln();
		}
		new MessageView(Message.HORIZONTAL_LINE).writeln();
	}

}

