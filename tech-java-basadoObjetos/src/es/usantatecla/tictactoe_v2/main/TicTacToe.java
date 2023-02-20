package es.usantatecla.tictactoe_v2.main;

import es.usantatecla.tictactoe_v2.main.models.Board;
import es.usantatecla.tictactoe_v2.main.models.Message;
import es.usantatecla.tictactoe_v2.main.models.Turn;
import es.usantatecla.tictactoe_v2.utils.YesNoDialog;

class TicTacToe {

	private Board board;
	private Turn turn;
	private BoardView boardView;
	private TurnView turnView;

	private TicTacToe() {
		this.board = new Board();
		this.boardView = new BoardView(this.board);
		this.turn = new Turn(this.board);
		this.turnView = new Turn(this.turn);
	}

	private void play() {
		do {
			this.playGame();
		} while (this.isResumedGame());
	}

	private void playGame() {
		Message.TITLE.writeln();
		this.boardView.write();
		do {
			this.turn.play();
			this.board.write();
		} while (!this.board.isTicTacToe(this.turn.getActiveColor()));
		this.turn.writeWinner();
	}

	private boolean isResumedGame() {
		YesNoDialog yesNoDialog = new YesNoDialog();
		yesNoDialog.read(Message.RESUME.toString());
		if (yesNoDialog.isAffirmative()) {
			this.board.reset();
			this.turn.reset();
		}
		return yesNoDialog.isAffirmative();
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}

}


/*

Eliminar la clase "YesNoDialog",
Añadir una clase "Piece"
Añadir la clase "Square"
Hacer una clase "Color"
Elimina la clase "Turn"...
O si tienes otra propuesta, también se acepta.

*/

