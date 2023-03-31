package utils;

public class ClosedIntervalDialog extends IntDialog {

    private ClosedInterval closedInterval;
    private String suffix;

    public ClosedIntervalDialog(int min, int max) {
        super();
        this.closedInterval = new ClosedInterval(min, max);
        this.errorMessage = "The value must be between " + min + " and " + max;
        this.suffix = "? [" +
                min + "-" +
                max + "]: ";
    }

    public int readWithSuffix() {
        return Console.getInstance().readInt(this.suffix);
    }

    public boolean isOk() {
        return this.closedInterval.isIncluded(this.getAnswer());
    }

}
