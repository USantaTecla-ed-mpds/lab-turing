package main.es.labturing.utils.views.menu;

import main.es.labturing.utils.views.Console;

public abstract class Option {

    protected String title;

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

    protected boolean isActive(){
        return true;
    }

}
