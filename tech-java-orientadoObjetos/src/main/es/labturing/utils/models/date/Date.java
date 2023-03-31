package main.es.labturing.utils.models.date;

import main.es.labturing.utils.views.Console;

public class Date {

	private int day;
	private Month month;
	private int year;
	private Format particularFormat = null;
	private static Format generalFormat = Format.SPANISH;

	public Date(int day, Month month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public Date(Date date) {
		this(date.day, date.month, date.year);
	}

	public Date() {
		this(1, Month.JANUARY, 2000);
	}

	public Date(String string) {
		day = Integer.parseInt(string.substring(0, string.indexOf("/")));
		string = string.substring(string.indexOf("/") + 1, string.length());
		month = Month.getMonth(Integer.parseInt(
				string.substring(0, string.indexOf("/"))));
		string = string.substring(string.indexOf("/") + 1, string.length());
		year = Integer.parseInt(string);
	}

	public Date copy() {
		return new Date(this);
	}

	public int getDay() {
		return day;
	}

	public Month getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public boolean equals(Date date) {
		return this.day == date.day &&
				this.month == date.month &&
				this.year == date.year;
	}

	public boolean posteriorA(Date date) {
		if (this.year == date.year) {
			if (this.month == date.month) {
				return this.day > date.day;
			} else {
				return this.month.ordinal() > date.month.ordinal();
			}
		} else {
			return this.year > date.year;
		}
	}

	public boolean anteriorA(Date date) {
		return !this.equals(date) && date.posteriorA(this);
	}

	public static void setGeneralFormat(Format generalFormat) {
		Date.generalFormat = generalFormat;
	}

	public void cambiarFormatoParticular(Format particularFormat) {
		this.particularFormat = particularFormat;
	}

	public String toString() {
		if (particularFormat == null) {
			return this.toString(Date.generalFormat);
		} else {
			return this.toString(this.particularFormat);
		}
	}

	public String toString(Format formato) {
		return formato.toString(this);
	}

	public Date next() {
		if (this.isLeapYear() &&
				this.equals(new Date(28, Month.FEBRUARY, year))) {
			return new Date(29, Month.FEBRUARY, year);
		} else if (day < month.getDays()) {
			return new Date(day + 1, month, year);
		} else if (month != Month.DECEMBER) {
			return new Date(1, month.getNext(), year);
		} else {
			return new Date(1, Month.JANUARY, year + 1);
		}
	}

	public int daysElapsedYear() {
		int days = day - 1;
		Month month = Month.JANUARY;
		while (month != this.month) {
			days += month.getDays();
			month = month.getNext();
		}
		if (this.isLeapYear() &&
				this.posteriorA(new Date(29, Month.FEBRUARY, year))) {
			days++;
		}
		return days;
	}

	public boolean isLeapYear() {
		return Date.isLeapYear(year);
	}

	public static boolean isLeapYear(int year) {
		return year % 4 == 0;
	}

	public static int daysInYear(int year) {
		int days = 365;
		if (Date.isLeapYear(year)) {
			days++;
		}
		return days;
	}

	public Date pasadosDias(int dias) {
		Date fecha = new Date(this);
		for (int i = 0; i < dias; i++) {
			fecha = fecha.next();
		}
		return fecha;
	}

	public static Date pasadosDiasAño(int dias, int año) {
		Date fecha = new Date(1, Month.JANUARY, año);
		return fecha.pasadosDias(dias);
	}

	public static void main(String[] args) {
		Console console = new Console();
		// Fecha fecha = new Fecha(31, Mes.MAYO, 2010);
		// gestorIO.escribirLinea(fecha.toString());
		// fecha = fecha.siguiente();
		// gestorIO.escribirLinea(fecha.toString());
		// Fecha f = new Fecha("30/5/2010");
		// gestorIO.escribirLinea(f.toString(Formato.ESPAÑOL));
		// gestorIO.escribirLinea(f.toString(Formato.INGLES));

		Date fecha = new Date(27, Month.JANUARY, 2015);
		Date fechaDespues = fecha.pasadosDias(77);
		Date fechaDespuesAño = Date.pasadosDiasAño(77, 2015);
		console.writeln("Fecha inicial: " + fecha.toString());
		console.writeln("77 días después: " + fechaDespues.toString());
		console.writeln("77 días desde comienzo de 2015: " +
				fechaDespuesAño.toString());
	}
}
