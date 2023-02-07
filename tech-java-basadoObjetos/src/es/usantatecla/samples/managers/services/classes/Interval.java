package es.usantatecla.samples.managers.services.classes;

import es.usantatecla.utils.Console;

public class Interval {

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

