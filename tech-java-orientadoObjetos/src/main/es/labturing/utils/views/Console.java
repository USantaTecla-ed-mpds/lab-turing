package main.es.labturing.utils.views;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

	private static Console instance = null;

	public static Console getInstance() {
		if (Console.instance == null) {
			Console.instance = new Console();
		}
		return Console.instance;
	}

	public Console() {
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

	public double readDouble(String title) {
		double input = 0;
		boolean ok = false;
		do {
			try {
				input = Double.parseDouble(this.readString(title));
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

	public void write(int value) {
		System.out.print(value);
	}

	public void write(double value) {
		System.out.print(value);
	}

	public void write(char character) {
		System.out.print(character);
	}

	public void write(boolean character) {
		System.out.print(character);
	}

	public void writeln() {
		System.out.println();
	}

	public void writeln(String string) {
		this.write(string);
		this.writeln();
	}

	public void writeln(int value) {
		this.write(value);
		this.writeln();
	}

	public void writeln(double value) {
		this.write(value);
		this.writeln();
	}

	public void writeln(char value) {
		this.write(value);
		this.writeln();
	}

	public void writeln(boolean value) {
		this.write(value);
		this.writeln();
	}

	public void writeError(String format) {
		this.write("FORMAT ERROR! Enter a " + format + " formatted value.");
		this.writeln();
	}

}
