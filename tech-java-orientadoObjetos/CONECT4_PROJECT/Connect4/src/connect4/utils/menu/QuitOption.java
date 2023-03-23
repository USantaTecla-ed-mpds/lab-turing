package connect4.utils.menu;

public class QuitOption extends Option {

    private boolean executed;

    public QuitOption() {
        super("Salir");
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
