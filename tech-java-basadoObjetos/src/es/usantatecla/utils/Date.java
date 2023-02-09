package es.usantatecla.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date {

	private int day;
	private int month;
	private int year;;
	public final static int DAYS_PER_YEAR = 360;
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

