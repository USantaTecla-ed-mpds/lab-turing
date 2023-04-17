package main.es.labturing.utils.views;

import main.es.labturing.connect4.views.MessageManager;

public abstract class IntDialog {
    protected String key;
    public String errorMessageKey;
    protected String suffix;
    protected int answer;

    public IntDialog() {
        this.key = "";
        this.suffix = "";
        this.errorMessageKey="";
    }

    public void read(String key) {
        boolean ok;
        do {
            MessageManager.getInstance().write(key);
            this.answer = this.readWithSuffix();
            ok = this.isOk();
            if (!ok) {
                MessageManager.getInstance().writeln(this.errorMessageKey);
            }
        } while (!ok);
    }

    public abstract int readWithSuffix();

    protected abstract boolean isOk();

    public int getAnswer() {
        return this.answer;
    }
}
