package main.es.labturing.utils.models.date;

enum Format {

	SPANISH,
	ENGLISH;

	String toString(Date date) {
		switch (this) {
			case SPANISH:
				return date.getDay() + " de " +
						date.getMonth().getName(this) + " de " +
						date.getYear();
			case ENGLISH:
				return date.getMonth().getName(this) + ", " +
						date.getDay() + "th " +
						date.getYear();
		}
		return null;
	}
}
