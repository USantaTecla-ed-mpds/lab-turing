package connect4.utils.menu;

import java.io.IOException;

import connect4.utils.exceptions.MessageNotFoundException;

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
    public void interact() throws MessageNotFoundException, ClassNotFoundException, IOException {
        this.addOptions();
        
        for (int i = 0; i < this.steps; i++) {
            this.interact_();
            this.counter++;
        }
    }

}
