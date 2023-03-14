package usantatecla.utils.views;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

	private static Console instance = new Console();
	
	public static Console getInstance() {
		return instance;
	}
	
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public String readString(String title) {
		String input = null;
		this.write(title);
		try {
			input = this.bufferedReader.readLine();
		} catch (Exception ex) {
		}
		return input;
	}

	public String readString() {
		return this.readString("");
	}

	public int readInt(String title) {
		int input = 0;
		boolean ok = false;
		do {
			try {
				input = Integer.parseInt(this.readString(title));
				ok = true;
			} catch (Exception ex) {
				this.writeError("integer");
			}
		} while (!ok);
		return input;
	}

	public char readChar(String title) {
		char charValue = ' ';
		boolean ok = false;
		do {
			String input = this.readString(title);
			if (input.length() != 1) {
				this.writeError("character");
			} else {
				charValue = input.charAt(0);
				ok = true;
			}
		} while (!ok);
		return charValue;
	}

	public void write(String string) {
		System.out.print(string);
	}

	public void write(int integer) {
		System.out.print(integer);
	}

	public void write(char character) {
		System.out.print(character);
	}

	public void writeln() {
		System.out.println();
	}

	public void writeln(String string) {
		this.write(string);
		this.writeln();
	}

	public void writeln(int integer) {
		this.write(integer);
		this.writeln();
	}

	public void writeError(String format) {
		this.write("FORMAT ERROR! Enter a " + format + " formatted value.");
		this.writeln();
	}

}
