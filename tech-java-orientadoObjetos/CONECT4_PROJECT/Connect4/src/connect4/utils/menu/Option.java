package connect4.utils.menu;

import java.io.IOException;

import connect4.models.exceptions.MessageNotFoundException;
import connect4.utils.Console;

public abstract class Option {

    protected String title;

    public Option(String title) {
        this.title = title;
    }

    public abstract void interact() throws MessageNotFoundException, ClassNotFoundException, IOException;

    public void showTitle(int index) {
        Console.getInstance().writeln(index + ". " + this.getTitle());
    }

    protected String getTitle() {
        return this.title;
    }

}
