package utils;

import views.Message;

public abstract class IntDialog {
    protected String message;
    public String errorMessage;
    protected String suffix;
    protected int answer;

    public IntDialog() {
        this.message = "";
        this.suffix = "";
        this.errorMessage="";
    }

    public void read(String message) {
        boolean ok;
        do {
            new Message(message).write();
            this.answer = this.readWithSuffix();
            ok = this.isOk();
            if (!ok) {
                new Message(this.errorMessage).writeln();
            }
        } while (!ok);
    }

    public abstract int readWithSuffix();

    protected abstract boolean isOk();

    public int getAnswer() {
        return this.answer;
    }
}
