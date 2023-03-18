package connect4.utils.menu;

import java.util.ArrayList;
import java.util.List;

import connect4.utils.Console;

abstract class Menu {

    private String title;
    private List<Option> options;

    public Menu(String title) {
        this.title = title;
        this.options = new ArrayList<Option>();
    }

    public void interact() {
        this.addOptions();
        this.interact_();
    }

    protected abstract void addOptions();

    protected void interact_() {
        this.showTitles();
        this.execChoosedOption();
    }

    protected void showTitles() {
        this.showTitle();
        for (int i = 0; i < this.options.size(); i++) {
            this.options.get(i).showTitle(i + 1);
        }
    }

    private void showTitle() {
        String string = "\n" + this.title + "\n";
        for (int i = 0; i < this.title.length(); i++) {
            string += "-";
        }
        Console.getInstance().writeln(string);
    }

    protected void execChoosedOption() {
        int answer;
        boolean ok;
        do {
            answer = Console.getInstance().readInt("Opción? [1-" + this.options.size() + "]: ") - 1;
            ok = 0 <= answer && answer <= this.options.size() - 1;
            if (!ok) {
                Console.getInstance().writeln("Error!!!");
            }
        } while (!ok);
        this.options.get(answer).interact();
    }

    protected void add(Option option) {
        this.options.add(option);
    }

    protected void removeOptions() {
        this.options.clear();
    }

    protected boolean hasOption(Option option) {
        return this.options.contains(option);
    }

}
