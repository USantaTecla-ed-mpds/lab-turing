package es.usantatecla.samples.managers.services.classes;

import es.usantatecla.utils.Console;

class Date {

	private int day;
	private int month;
	private int year;;
	public final int DAYS_PER_YEAR = 360;
	private final int DAYS_PER_MONTH = 30;
	private final int MONTHS_PER_YEAR = 12;

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public Date(Date date) {
		this(date.day, date.month, date.year);
	}

	public Date() {
		this(1, 1, 1900);
	}

	public Date clone() {
		return new Date(this);
	}

	public boolean equals(Date date) {
		return this.day == date.day
				&& this.month == date.month
				&& this.year == date.year;
	}

	public boolean after(Date date) {
		if (this.year == date.year) {
			if (this.month == date.month) {
				return this.day > date.day;
			}
			return this.month > date.month;
		}
		return this.year > date.year;
	}

	public boolean before(Date date) {
		return !this.equals(date) && date.after(this);
	}

	public Date next() {
		if (day < this.DAYS_PER_MONTH) {
			return new Date(day + 1, month, year);
		}
		if (month != this.MONTHS_PER_YEAR) {
			return new Date(1, month + 1, year);
		}
		return new Date(1, 1, year + 1);
	}

	public Date next(int days) {
		Date date = this.clone();
		for (int i = 0; i < days; i++) {
			date = date.next();
		}
		return date;
	}

	public int daysElapsedYear() {
		return (this.day-1) + (this.month - 1) * this.DAYS_PER_MONTH;
	}

	public int getDay() {
		return this.day;
	}

	public int getMonth() {
		return this.month;
	}

	public int getYear() {
		return this.year;
	}

	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}

class Interval {

	private double min;
	private double max;

	public Interval(double min, double max) {
		this.min = min;
		this.max = max;
	}

	public Interval(double max) {
		this(0, max);
	}

	public Interval() {
		this(0);
	}

	public Interval clone() {
		return new Interval(this);
	}

	private Interval(Interval interval) {
		this(interval.min, interval.max);
	}

	public double length() {
		return this.max - this.min;
	}

	public double middlePoint() {
		return (this.min + this.max) / 2;
	}

	public void scale(double scale) {
		double newMiddelPoint = this.middlePoint();
		double newLength = this.length() * scale;
		this.min = newMiddelPoint - newLength / 2;
		this.max = newMiddelPoint + newLength / 2;
	}

	public Interval scaled(double scale) {
		Interval scaled = this.clone();
		scaled.scale(scale);
		return scaled;
	}

	public Interval opposite() {
		return new Interval(-this.max, -this.min);
	}

	public boolean includes(double point) {
		return this.min <= point && point <= this.max;
	}

	public boolean includes(Interval interval) {
		return this.includes(interval.min)
				&& this.includes(interval.max);
	}

	public boolean isIntersected(Interval interval) {
		return this.includes(interval.min)
				|| this.includes(interval.max)
				|| interval.includes(this);
	}

	public Interval intersection(Interval interval) {
		Interval intersection = this.clone();
		if (interval.min > this.min) {
			intersection.min = interval.min;
		}
		if (interval.max < this.max) {
			intersection.max = interval.max;
		}
		return intersection;
	}

	// public Interval intersection(Interval intervalo) {
	// if (this.includes(intervalo)) {
	// return intervalo.clone();
	// } else if (intervalo.includes(this)) {
	// return this.clone();
	// } else if (this.includes(intervalo.min)) {
	// return new Interval(intervalo.min, this.max);
	// } else if (this.includes(intervalo.max)) {
	// return new Interval(this.min, intervalo.max);
	// } else {
	// return null;
	// }
	// }

	public Interval union(Interval interval) {
		Interval union = this.clone();
		if (interval.min < this.min) {
			union.min = interval.min;
		}
		if (interval.max > this.max) {
			union.max = interval.max;
		}
		return union;
	}

	public Interval shifted(float shiftment) {
		return new Interval(this.min + shiftment, this.max + shiftment);
	}

	public void shift(double cantidad) {
		this.min += cantidad;
		this.max += cantidad;
	}

	public Interval[] split(int times) {
		Interval[] intervals = new Interval[times];
		final double length = this.length() / times;
		double origin = this.min;
		for (int i = 0; i < intervals.length; i++) {
			intervals[i] = new Interval(origin, origin + length);
			origin += length;
		}
		return intervals;
	}

	public void read() {
		Console console = new Console();
		boolean error;
		do {
			this.min = console.readFloat("Dame el mínimo del intervalo: ");
			this.max = console.readFloat("Dame el máximo del intervalo: ");
			error = this.min <= this.max;
			if (error) {
				console.writeln("El minimo no puede ser mayor que el maximo");
			}
		} while (error);
	}

	public void writeln() {
		new Console().writeln(this.toString());
	}

	public String toString() {
		return "[" + this.min + ", " + this.max + "]";
	}

}

class ServicesContract {

	private String name;
	private final int year;
	private Interval[] intervals;
	private final Interval PRESET_INTERVAL = new Interval(8.0, 12.0);
	private final double PRESET_COST_PER_HOUR = 70.0;
	private final double EXTRAORDINARY_COST_PER_HOUR = 90.0;

	public ServicesContract(String name, int year) {
		this.name = name;
		this.year = year;
		intervals = new Interval[new Date(1, 1, year).DAYS_PER_YEAR];
		for (int i = 0; i < intervals.length; i++) {
			intervals[i] = PRESET_INTERVAL.clone();
		}
	}

	public void cancel(Date date) {
		intervals[date.daysElapsedYear()] = null;
	}

	public void enlarge(Date date, double scale) {
		intervals[date.daysElapsedYear()].scale(scale);
	}

	public void shift(Date date, double shiftment) {
		intervals[date.daysElapsedYear()].shift(shiftment);
	}

	public void writeln() {
		Console console = new Console();
		console.writeln("Contrato de limpieza: " + name + "-" + year);
		Date date = new Date(1, 1, year);
		for (int i = 0; i < intervals.length; i++) {
			console.write("(" + (i + 1) + ") " + date + " - ");
			if (intervals[i] == null) {
				console.writeln("Anulado");
			} else {
				console.writeln(intervals[i].toString());
			}
			date = date.next();
		}
	}

	public double getCost() {
		double cost = 0.0;
		for (Interval interval : this.intervals) {
			if (interval != null) {
				double presetHours = 0.0;
				Interval intersection = interval.intersection(PRESET_INTERVAL);
				if (intersection != null) {
					presetHours = intersection.length();
					cost += presetHours * PRESET_COST_PER_HOUR;
				}
				cost += (interval.length() - presetHours)
						* EXTRAORDINARY_COST_PER_HOUR;
			}
		}
		return cost;
	}

	public static void main(String[] args) {
		Console console = new Console();
		final int YEAR = 2022;
		ServicesContract servicesContract = new ServicesContract("USantaTecla", YEAR);

		servicesContract.writeln();
		double cost = servicesContract.getCost();
		console.writeln("Coste anual del contrato: " + cost);

		servicesContract.cancel(new Date(25, 12, YEAR));
		servicesContract.writeln();
		cost = servicesContract.getCost();
		console.writeln("Coste anual del contrato: " + cost);

		servicesContract.enlarge(new Date(24, 12, YEAR), 2.0);
		servicesContract.writeln();
		cost = servicesContract.getCost();
		console.writeln("Coste anual del contrato: " + cost);

		servicesContract.shift(new Date(26, 12, YEAR), 1.0);
		servicesContract.writeln();
		cost = servicesContract.getCost();
		console.writeln("Coste anual del contrato: " + cost);
	}
}