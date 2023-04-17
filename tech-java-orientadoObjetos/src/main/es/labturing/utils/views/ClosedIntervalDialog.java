package main.es.labturing.utils.views;

import main.es.labturing.utils.models.ClosedInterval;

public class ClosedIntervalDialog extends IntDialog {

    private ClosedInterval closedInterval;
    private String suffix;

    public ClosedIntervalDialog(int min, int max) {
        super();
        this.closedInterval = new ClosedInterval(min, max);
        this.errorMessageKey = "ERR_INVALID_COLUMN_TO_DROP";
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
