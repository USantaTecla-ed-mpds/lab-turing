package main.es.labturing.ServiceContractManagement.models;

import main.es.labturing.utils.models.Interval;
import main.es.labturing.utils.models.date.Date;

public class ServicesContract {

	private final int year;
	private Interval[] timetable;
	private static final Interval PRESET_INTERVAL = new Interval(8.0, 12.0);
	private static final double PRESET_COST_PER_HOUR = 70.0;
	private static final double EXTRAORDINARY_COST_PER_HOUR = 90.0;

	public ServicesContract(int year) {
		this.year = year;
		timetable = new Interval[Date.daysInYear(year)];
		for (int i = 0; i < timetable.length; i++) {
			timetable[i] = PRESET_INTERVAL.copy();
		}
	}

	public void cancel(Date date) {
		assert date.getYear() == year;
		assert this.timetable[date.daysElapsedYear()] != null;

		this.timetable[date.daysElapsedYear()] = null;
	}

	public void enlarge(Date date, double factor) {
		assert date.getYear() == year;
		assert timetable[date.daysElapsedYear()] != null;

		this.timetable[date.daysElapsedYear()].escale(factor);
	}

	public void shift(Date date, double shiftment) {
		assert date.getYear() == year;
		assert timetable[date.daysElapsedYear()] != null;
		timetable[date.daysElapsedYear()].shift(shiftment);
	}

	public double getCost() {
		double cost = 0.0;
		for (int i = 0; i < timetable.length; i++) {
			cost += this.cost(timetable[i]);
		}
		return cost;
	}

	public double cost(Interval interval) {
		if (interval == null) {
			return 0.0;
		}
		double cost = 0.0;
		double presetHours = 0.0;
		Interval intersection = interval.intersection(PRESET_INTERVAL);
		if (intersection != null) {
			presetHours = intersection.length();
			cost += presetHours * PRESET_COST_PER_HOUR;
		}
		cost += (interval.length() - presetHours)
				* EXTRAORDINARY_COST_PER_HOUR;
		return cost;
	}

	public boolean containsInterval(Date date) {
		return this.timetable[date.daysElapsedYear()] != null;
	}

	public int getYear() {
		return this.year;
	}

	public Interval[] getTimetable() {
		return timetable;
	}

}
