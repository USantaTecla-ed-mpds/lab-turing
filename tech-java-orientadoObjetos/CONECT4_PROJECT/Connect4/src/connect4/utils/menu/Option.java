package connect4.utils.menu;

import java.io.IOException;

import connect4.utils.Console;
import connect4.utils.exceptions.MessageNotFoundException;

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
