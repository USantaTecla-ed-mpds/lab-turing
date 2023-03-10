package main.es.pbover.utils.menu;

import main.es.pbover.utils.Console;

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
