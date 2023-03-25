package connect4.utils.menu;

import java.io.IOException;

import connect4.utils.exceptions.MessageNotFoundException;

public abstract class DynamicMenu extends IterativeMenu {

    public DynamicMenu(String title) throws MessageNotFoundException {
        super(title);
    }

    @Override
    public void interact() throws MessageNotFoundException, ClassNotFoundException, IOException {
        do {
            this.removeOptions();
            this.addOptions();
            this.interact_();
        } while (!this.isExecutedquitOption());
    }

}
