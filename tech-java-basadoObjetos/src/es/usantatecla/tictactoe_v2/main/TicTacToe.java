package es.usantatecla.tictactoe_v2.main;

import es.usantatecla.tictactoe_v2.main.models.Board;
import es.usantatecla.tictactoe_v2.main.models.Turn;
import es.usantatecla.tictactoe_v2.main.models.Message;
import es.usantatecla.tictactoe_v2.main.views.MessageView;
import es.usantatecla.tictactoe_v2.main.views.BoardView;
import es.usantatecla.tictactoe_v2.main.views.TurnView;
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
		this.turnView = new TurnView(this.turn);
	}

	private void play() {
		do {
			this.playGame();
		} while (this.isResumedGame());
	}

	private void playGame() {
		new MessageView(Message.TITLE).writeln();
		this.boardView.write();
		do {
			this.turnView.play();
			this.boardView.write();
		} while (!this.board.isTicTacToe(this.turn.getActiveColor()));
		this.turnView.writeWinner();
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

Separar Vistas
Enmascarar coordinate con boundedCoordinate

*/

