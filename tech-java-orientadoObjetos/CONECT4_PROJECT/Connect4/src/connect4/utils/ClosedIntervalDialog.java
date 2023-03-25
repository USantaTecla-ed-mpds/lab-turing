package connect4.utils;

public class ClosedIntervalDialog extends Dialog<Integer> {

    protected ClosedInterval closedInterval;

    public ClosedIntervalDialog(int min, int max) {
        this.closedInterval = new ClosedInterval(min, max);
        this.errorMessage = "The value must be between " + min + " and " + max + "?";
        this.suffix = "[" + min + "-" + max + "]: ";
    }

    public Integer askAnswer() {
        return Console.getInstance().readInt(this.suffix);
    }

    public boolean isAnswerOk() {
        return this.closedInterval.isIncluded(this.getAnswer());
    }

}
