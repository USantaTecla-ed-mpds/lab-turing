package es.usantatecla.companyManagement;

import es.usantatecla.utils.Console;
import es.usantatecla.utils.Date;
import es.usantatecla.utils.Interval;


public class ServicesContract {

	private String name;
	private final int year;
	private Interval[] intervals;
	private final Interval PRESET_INTERVAL = new Interval(8.0, 12.0);
	private final double PRESET_COST_PER_HOUR = 70.0;
	private final double EXTRAORDINARY_COST_PER_HOUR = 90.0;

	public ServicesContract(String name, int year) {
		this.name = name;
		this.year = year;
		this.intervals = new Interval[Date.DAYS_PER_YEAR];
		for (int i = 0; i < this.intervals.length; i++) {
			this.intervals[i] = this.PRESET_INTERVAL.clone();
		}
	}

	public void cancel(Date date) {
		this.intervals[date.daysElapsedYear()] = null;
	}

	public void enlarge(Date date, double scale) {
		this.intervals[date.daysElapsedYear()].scale(scale);
	}

	public void shift(Date date, double shiftment) {
		this.intervals[date.daysElapsedYear()].shift(shiftment);
	}

	public void writeln() {//todo to view
		Console console = new Console();
		console.writeln("Contrato de limpieza: " + name + "-" + year);
		Date date = new Date(1, 1, year);
		for (int i = 0; i < this.intervals.length; i++) {
			console.write("(" + (i + 1) + "º) " + date + " - ");
			if (this.intervals[i] == null) {
				console.writeln("Cancelado");
			} else {
				console.writeln(this.intervals[i].toString());
			}
			date = date.next();
		}
	}

	public double getCost() {
		double cost = 0.0;
		for (Interval interval : this.intervals) {
			if (interval != null) {
				double presetHours = 0.0;
				Interval intersection = interval.intersection(this.PRESET_INTERVAL);
				if (intersection != null) {
					presetHours = intersection.length();
					cost += presetHours * this.PRESET_COST_PER_HOUR;
				}
				cost += (interval.length() - presetHours)
						* this.EXTRAORDINARY_COST_PER_HOUR;
			}
		}
		return cost;
	}

	public String getName(){
		return this.name;
	}

	public int getYear(){
		return this.year;
	}

}