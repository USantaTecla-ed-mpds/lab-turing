package connect4.utils.menu;

import java.io.IOException;

import connect4.models.exceptions.MessageNotFoundException;

public abstract class IterativeMenu extends QuitMenu {

    public IterativeMenu(String title) throws MessageNotFoundException {
        super(title);
    }

    @Override
    public void interact() throws MessageNotFoundException, ClassNotFoundException, IOException {
        this.addOptions();
        do {
            this.interact_();
        } while (!this.isExecutedquitOption());
    }

}
