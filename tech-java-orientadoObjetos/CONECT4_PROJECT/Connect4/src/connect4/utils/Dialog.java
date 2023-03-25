package connect4.utils;

public abstract class Dialog<E> {
    protected String suffix;
    protected String message;
    public String errorMessage;
    protected E answer;

    public Dialog() {
        this.message = "";
        this.errorMessage = "";
    }

    public void show(String message) {
        this.message = message;
        boolean ok;
        do {
            Console.getInstance().write(message);
            this.answer = this.askAnswer();
            ok = this.isAnswerOk();
            if (!ok) {
                Console.getInstance().writeln(this.errorMessage);
            }
        } while (!ok);
    }

    protected abstract E askAnswer();

    protected abstract boolean isAnswerOk();

    public E getAnswer() {
        return this.answer;
    }
}
