package es.usantatecla.tictactoe.src.main.java.es.usantatecla.tictactoe;


class TicTacToe {

	private Board board;
	private Turn turn;

	private String answer;

	private TicTacToe() {
		this.board = new Board();
		this.turn = new Turn(this.board);
	}

	private void play() {
		do {
			this.playGame();
		} while (this.isResumedGame());
	}

	private void playGame() {
		Message.TITLE.writeln();
		this.board.write();
		do {
			this.turn.play();
			this.board.write();
		} while (!this.board.isTicTacToe(this.turn.getActiveColor()));
		this.turn.writeWinner();
	}

	private boolean isResumedGame() {
		this.read(Message.RESUME.toString());
		if (this.isAffirmative()) {
			this.board.reset();
			this.turn.reset();
		}
		return this.isAffirmative();
	}

	public void read(String message) {
		assert message != null;

		Console console = Console.getInstance();
		boolean ok;
		do {
			console.write(message);
			this.answer = console.readString(Message.YES_NO_SUFFIX.toString());
			ok = this.isAffirmative() || this.isNegative();
			if (!ok) {
				console.writeln(Message.YES_NO_ERROR.toString());
			}
		} while (!ok);
	}

	public boolean isAffirmative() {
		return Character.toLowerCase(this.answer.charAt(0)) == Message.AFFIRMATIVE;
	}

	public boolean isNegative() {
		return Character.toLowerCase(this.answer.charAt(0)) == Message.NEGATIVE;
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}

}


