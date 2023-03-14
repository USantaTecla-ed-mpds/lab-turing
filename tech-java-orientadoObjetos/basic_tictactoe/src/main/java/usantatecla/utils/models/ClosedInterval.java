package usantatecla.utils.models;

public class ClosedInterval {

	private int min;
	private int max;

	public ClosedInterval(int min, int max) {
		assert min <= max;
		
		this.min = min;
		this.max = max;
	}

	public boolean isIncluded(int value) {
		return this.min <= value && value <= this.max;
	}
	
	@Override
	public String toString() {
		return "[" + this.min + ", " + this.max + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClosedInterval other = (ClosedInterval) obj;
		if (min != other.min)
			return false;
		if (max != other.max)
			return false;
		return true;
	}

}
