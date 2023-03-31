package main.es.labturing.utils.views.menu;

public class QuitOption extends Option {

    private boolean executed;

    public QuitOption() {
        super("Exit");
        this.executed = false;
    }

    public QuitOption(String title) {
        super(title);
        this.executed = false;
    }

    @Override
    public void interact() {
        this.executed = true;
    }

    public boolean isExecuted() {
        return this.executed;
    }

}
