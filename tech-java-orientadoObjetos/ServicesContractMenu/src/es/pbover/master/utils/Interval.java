package es.pbover.master.utils;

import es.pbover.master.utils.io.Console;

public class Interval {

	private double min;
	private double max;

	public Interval(double min, double max) {
		this.min = min;
		this.max = max;
	}

	public Interval() {
		this(0, 0);
	}

	public Interval(Interval interval) {
		this(interval.min, interval.max);
	}

	public Interval(String string) {
		int hours = Integer.parseInt(string.substring(
				0, string.indexOf(":")).trim());
		// hours = Integer.valueOf(string.substring(
		// 0, cadena.indexOf(":")).trim());
		int minutes = Integer.parseInt(string.substring(string.indexOf(":") + 1,
				string.indexOf("-")).trim());
		min = hours + minutes / 60.0;
		// cadena = cadena.substring(cadena.indexOf("-") + 1);
		hours = Integer.parseInt(
				string.substring(string.indexOf("-") + 1, string.indexOf(":")).trim());
		minutes = Integer.parseInt(
				string.substring(string.indexOf(":") + 1).trim());
		max = hours + minutes / 60.0;
	}

	// public Interval(String cadena) {
	// String exreg = ":|-";
	// String[] datos = cadena.split(exreg);
	// minimo = Integer.parseInt(datos[0].trim()) +
	// Integer.parseInt(datos[1].trim()) / 60.0;
	// maximo = Integer.parseInt(datos[2].trim()) +
	// Integer.parseInt(datos[3].trim()) / 60.0;
	// }

	public String toString() {
		return "[" + this.min + ", " + this.max + "]";
	}

	public double length() {
		return max - min;
	}

	public double middlePoint() {
		return (max + min) / 2;
	}

	public Interval copy() {
		return new Interval(this);
	}

	public Interval symetric() {
		return new Interval(-max, -min);
	}

	public void shift(double cantidad) {
		min += cantidad;
		max += cantidad;
	}

	public void escale(double escala) {
		double nuevaLongitud = this.length() * escala;
		double puntoMedio = this.middlePoint();
		min = puntoMedio - nuevaLongitud / 2;
		max = puntoMedio + nuevaLongitud / 2;
	}

	public boolean includes(double punto) {
		return min <= punto && punto <= max;
	}

	public boolean includes(Interval intervalo) {
		return this.includes(intervalo.min)
				&& this.includes(intervalo.max);
	}

	public boolean equals(Interval intervalo) {
		return min == intervalo.min
				&& max == intervalo.max;
	}

	public Interval intersection(Interval intervalo) {
		if (this.includes(intervalo)) {
			return intervalo.copy();
		} else if (intervalo.includes(this)) {
			return this.copy();
		} else if (this.includes(intervalo.min)) {
			return new Interval(intervalo.min, this.max);
		} else if (this.includes(intervalo.max)) {
			return new Interval(this.min, intervalo.max);
		} else {
			return null;
		}
	}

	public Interval shifted(double cantidad) {
		Interval intervalo = this.copy();
		intervalo.shift(cantidad);
		return intervalo;
	}

	public void read() {
		Console console = new Console();
		do {
			min = console.readDouble("Introduce el minimo: ");
			max = console.readDouble("Introduce el maximo: ");
			if (min > max) {
				console.writeln("El minimo no puede ser mayor que el maximo");
			}
		} while (min > max);
	}

	public static void main(String[] args) {
		Console console = new Console();
		// Intervalo intervalo = new Intervalo();
		// intervalo.recoger();
		// gestorIO.escribirLinea();
		// gestorIO.escribirLinea("Longitud: " + intervalo.longitud());
		// gestorIO.escribirLinea("Punto medio: " + intervalo.puntoMedio());
		// gestorIO.escribirLinea("Simetrico: " + intervalo.simetrico().toString());
		// Intervalo copia = intervalo.copia();
		// intervalo.desplazar(7.7);
		// gestorIO.escribirLinea("Desplazado 7.7: " + intervalo.toString());
		// gestorIO.escribirLinea("Incluye 3.3? " + intervalo.incluye(3.3));
		// gestorIO.escribirLinea("Incluye al original? "
		// + intervalo.incluye(copia));

		Interval intervalo = new Interval("12:00-13:00");
		console.writeln(intervalo.toString());

		intervalo = new Interval(" 9 : 15 - 10 : 30 ");
		console.writeln(intervalo.toString());

		// System.out.println(intervalo.toString());

	}
}
