package main.es.labturing.utils.models.date;

public enum Month {

	JANUARY(31, new String[] { "Enero", "January" }),
	FEBRUARY(28, new String[] { "Febrero", "February" }),
	MARCH(31, new String[] { "Marzo", "March" }),
	APRIL(30, new String[] { "Abril", "April" }),
	MAY(31, new String[] { "Mayo", "May" }),
	JUNE(30, new String[] { "Junio", "June" }),
	JULY(31, new String[] { "Julio", "July" }),
	AUGUST(31, new String[] { "Agosto", "August" }),
	SEPTEMBER(30, new String[] { "Septiembre", "September" }),
	OCTOBER(31, new String[] { "Octubre", "October" }),
	NOVEMBER(30, new String[] { "Noviembre", "November" }),
	DECEMBER(31, new String[] { "Diciembre", "December" });

	private int days;
	private String[] names;

	private Month(int days, String[] names) {
		this.days = days;
		this.names = names;
	}

	public int getDays() {
		return days;
	}

	public static Month getMonth(int month) {
		return Month.values()[month - 1];
	}

	public String getName(Format format) {
		return names[format.ordinal()];
	}

	public Month getNext() {
		return Month.values()[(this.ordinal() + 1) % Month.values().length];
	}

	public Month getPrevious() {
		if (this == Month.JANUARY) {
			return Month.DECEMBER;
		} else {
			return Month.values()[this.ordinal() - 1];
		}
	}
}
