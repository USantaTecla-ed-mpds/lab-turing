package es.usantatecla.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

    private BufferedReader bufferedReader =
			new BufferedReader(new InputStreamReader(System.in));

	public String readString(String title) {
		String input = null;
		boolean ok = false;
		do {
			this.write(title);
			try {
				input = bufferedReader.readLine();
				ok = true;
			} catch (Exception e) {
				this.writeError("de cadena de caracteres");
			}
		} while (!ok);
		return input;
	}

	public int readInt(String title) {
		int input = 0;
		boolean ok = false;
		do {
			try {
				input = Integer.parseInt(this.readString(title));
				ok = true;
			} catch (Exception e) {
				this.writeError("entero");
			}
		} while (!ok);
		return input;
	}

	public float readFloat(String title) {
		float input = 0;
		boolean ok = false;
		do {
			try {
				input = Float.parseFloat(this.readString(title));
				ok = true;
			} catch (Exception e) {
				this.writeError("real");
			}
		} while (!ok);
		return input;
	}

	public double readDouble(String title) {
		double input = 0.0;
		boolean ok = false;
		do {
			try {
				input = Double.parseDouble(this.readString(title));
				ok = true;
			} catch (Exception e) {
				this.writeError("real");
			}
		} while (!ok);
		return input;
	}

	public long readLong(String title) {
		long input = 0;
		boolean ok = false;
		do {
			try {
				input = Long.parseLong(this.readString(title));
				ok = true;
			} catch (Exception e) {
				this.writeError("entero");
			}
		} while (!ok);
		return input;
	}

	public byte readByte(String title) {
		byte input = 0;
		boolean ok = false;
		do {
			try {
				input = Byte.parseByte(this.readString(title));
				ok = true;
			} catch (Exception e) {
				this.writeError("entero");
			}
		} while (!ok);
		return input;
	}

	public short readShort(String title) {
		short input = 0;
		boolean ok = false;
		do {
			try {
				input = Short.parseShort(this.readString(title));
				ok = true;
			} catch (Exception e) {
				this.writeError("entero");
			}
		} while (!ok);
		return input;
	}

	public char readChar(String title) {
		char caracter = ' ';
		boolean ok = false;
		do {
			String input = this.readString(title);
			if (input.length() != 1) {
				this.writeError("caracter");
			} else {
				caracter = input.charAt(0);
				ok = true;
			}
		} while (!ok);
		return caracter;
	}

	public boolean readBoolean(String title) {
		boolean inputLogica = true;
		boolean ok = false;
		do {
			String input = this.readString(title);
			if (input.equalsIgnoreCase("true") ||
					input.equalsIgnoreCase("false")) {
				inputLogica = Boolean.valueOf(input).booleanValue();
				ok = true;
			} else {
				this.writeError("logico");
			}
		} while (!ok);
		return inputLogica;
	}

	public void writeln() {
		this.write("\n");
	}

	public void write(String value) {
		System.out.print(value);
	}

	public void write(String[] values) {
		for(String value : values) {
			this.write(value);
		}
	}

	public void writeln(String value) {
		this.write(value);
		this.writeln();
	}

	public void writeln(String[] values) {
		for(String value : values) {
			this.writeln(value);
		}
	}

	public void write(int value) {
		System.out.print(value);
	}

	public void write(int[] values) {
		for(int value : values) {
			this.write(value + " - ");
		}
	}

	public void writeln(int value) {
		this.write(value);
		this.writeln();
	}

	public void writeln(int[] values) {
		for(int value : values) {
			this.writeln(value);
		}
	}

	public void write(float value) {
		System.out.print(value);
	}

	public void write(float[] values) {
		for(float value : values) {
			this.write(value + " - ");
		}
	}

	public void writeln(float value) {
		this.write(value);
		this.writeln();
	}

	public void writeln(float[] values) {
		for(float value : values) {
			this.writeln(value);
		}
	}

	public void write(double value) {
		System.out.print(value);
	}

	public void write(double[] values) {
		for(double value : values) {
			this.write(value + " - ");
		}
	}

	public void writeln(double value) {
		this.write(value);
		this.writeln();
	}

	public void writeln(double[] values) {
		for(double value : values) {
			this.writeln(value);
		}
	}
	
	public void write(long value) {
		System.out.print(value);
	}

	public void write(long[] values) {
		for(long value : values) {
			this.write(value + " - ");
		}
	}

	public void writeln(long value) {
		this.write(value);
		this.writeln();
	}

	public void writeln(long[] values) {
		for(long value : values) {
			this.writeln(value);
		}
	}

	public void write(byte value) {
		System.out.print(value);
	}
	
	public void write(byte[] values) {
		for(byte value : values) {
			this.write(value + " - ");
		}
	}
	
	public void writeln(byte value) {
		this.write(value);
		this.writeln();
	}

	public void writeln(byte[] values) {
		for(byte value : values) {
			this.writeln(value);
		}
	}

	public void write(short value) {
		System.out.print(value);
	}

	public void write(short[] values) {
		for(short value : values) {
			this.write(value + " - ");
		}
	}

	public void writeln(short value) {
		this.write(value);
		this.writeln();
	}

	public void writeln(short[] values) {
		for(short value : values) {
			this.writeln(value);
		}
	}

	public void write(char value) {
		System.out.print(value);
	}

	public void write(char[] values) {
		for(char value : values) {
			this.write(value + " - ");
		}
	}

	public void writeln(char value) {
		this.write(value);
		this.writeln();
	}

	public void writeln(char[] values) {
		for(char value : values) {
			this.writeln(value);
		}
	}

	public void write(boolean value) {
		System.out.print(value);
	}

	public void write(boolean[] values) {
		for(boolean value : values) {
			this.write(value + " - ");
		}
	}

	public void writeln(boolean value) {
		this.write(value);
		this.writeln();
	}

	public void writeln(boolean[] values) {
		for(boolean value : values) {
			this.writeln(value);
		}
	}

	private void writeError(String formato) {
		System.out.println("ERROR DE FORMATO! " +
				"Introduzca un valor con formato " + formato + ".");
	}

}
