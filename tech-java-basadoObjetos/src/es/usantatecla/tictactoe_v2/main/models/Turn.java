package es.usantatecla.tictactoe_v2.main.models;

import es.usantatecla.tictactoe_v2.utils.ClosedInterval;

public class Turn {

	private Board board;
	private static final int NUMBER_PLAYERS = 2;
	private Player[] players;
	private int activePlayerIndex;

	public Turn(Board board) {
		assert board != null;

		this.board = board;
		this.players = new Player[Turn.NUMBER_PLAYERS];
		this.reset();
	}

	public void reset() {
		for (int i = 0; i < NUMBER_PLAYERS; i++) {
			this.players[i] = new Player(Color.get(i), this.board);
		}
		this.activePlayerIndex = 0;
	}

	public void play() {
		if (!this.board.isTicTacToe(this.getActiveColor())) {
			this.activePlayerIndex = (this.activePlayerIndex + 1) % Turn.NUMBER_PLAYERS;
		}
	}

	public Color getActiveColor() {
		return this.players[this.activePlayerIndex].getColor();
	}

	/*public int getActivePlayerIndex() {
		return this.activePlayerIndex;
	}*/

	public Player getPlayer(int index) {
		assert new ClosedInterval(0, NUMBER_PLAYERS - 1).isIncluded(index);

		return this.players[index];
	}

	public static int getNumberOfPlayers() {
		return Turn.NUMBER_PLAYERS;
	}

}
