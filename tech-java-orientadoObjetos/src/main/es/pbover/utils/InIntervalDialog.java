package main.es.pbover.utils;

public class InIntervalDialog extends IntDialog {
    private int min;
    private int max;
    private String suffix;
    public InIntervalDialog(int min, int max) {
        super();
        this.min = min;
        this.max = max;
        this.errorMessage = "The value must be between "+min+" and "+max;
        this.suffix = "? [" +
            min + "-" +
            max + "]: ";
    }

    public int readWithSuffix() {
        return Console.getInstance().readInt(this.suffix);
    }

    public boolean isOk() {
        return new ClosedInterval(this.min, this.max).isIncluded(this.getAnswer());
    }

}
