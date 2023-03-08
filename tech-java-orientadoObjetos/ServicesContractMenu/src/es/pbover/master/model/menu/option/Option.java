package es.pbover.master.model.menu.option;

import es.pbover.master.utils.io.Console;

public abstract class Option {

    private String title;

    public Option(String title) {
        this.title = title;
    }

    public abstract void interact();

    public void showTitle(int index) {
        Console.getInstance().writeln(index + ". " + this.getTitle());
    }

    protected String getTitle() {
        return this.title;
    }

}
