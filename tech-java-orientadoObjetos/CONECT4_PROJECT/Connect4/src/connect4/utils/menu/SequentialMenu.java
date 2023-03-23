package connect4.utils.menu;

public abstract class SequentialMenu extends Menu {

    protected int steps;
    protected int counter = 0;

    public SequentialMenu(String title, int steps) {
        super(title);
        this.steps = steps;
    }

    public SequentialMenu(int steps) {
        super("");
        this.steps = steps;
    }

    @Override
    public void interact() {
        this.addOptions();
        do {
            this.interact_();
            this.counter++;
        } while (this.counter < this.steps);
        this.finalizeSequence();
    }

    protected abstract void finalizeSequence();
}
