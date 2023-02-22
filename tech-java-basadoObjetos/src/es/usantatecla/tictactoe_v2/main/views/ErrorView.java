package es.usantatecla.tictactoe_v2.main.views;

import es.usantatecla.tictactoe_v2.utils.Console;
import es.usantatecla.tictactoe_v2.main.models.Error;

public class ErrorView {

	private Error error;

	public ErrorView(Error error) {
		
		this.error = error;
	}

	public void writeln() {
		if (!this.error.isNull()) {
			Console.getInstance().writeln(this.error.getMessage());
		}
	}

}
