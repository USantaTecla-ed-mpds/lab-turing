package connect4.utils;

import connect4.models.Message;

public class InIntervalDialog extends IntDialog {
    private int min;
    private int max;
    private String suffix;

    public InIntervalDialog(int min, int max) {
        super();
        this.min = min;
        this.max = max;

        this.errorMessage = Message.ERR_NUM_PLAYERS.getFormatedMessage(
                String.valueOf(this.min),
                String.valueOf(this.max));

        this.suffix = Message.SUFIX.getFormatedMessage(
                String.valueOf(this.min),
                String.valueOf(this.max));
    }

    public int readWithSuffix() {
        return Console.getInstance().readInt(this.suffix);
    }

    public boolean isOk() {
        return new ClosedInterval(this.min, this.max).isIncluded(this.getAnswer());
    }

}
