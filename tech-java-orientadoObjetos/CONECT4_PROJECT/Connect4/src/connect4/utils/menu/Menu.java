package connect4.utils.menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import connect4.utils.Console;
import connect4.utils.exceptions.MessageNotFoundException;
import connect4.views.MessageManager;

public abstract class Menu {

    protected String title;
    private List<Option> options;

    public Menu(String title) {
        this.title = title;
        this.options = new ArrayList<Option>();
    }

    public void interact() throws MessageNotFoundException, ClassNotFoundException, IOException {
        this.addOptions();
        this.interact_();
    }

    protected abstract void addOptions() throws MessageNotFoundException;

    protected void interact_() throws MessageNotFoundException, ClassNotFoundException, IOException {
        this.showTitles();
        this.execChoosedOption();
    }

    protected void showTitles() throws MessageNotFoundException {
        this.showTitle();
        for (int i = 0; i < this.options.size(); i++) {
            this.options.get(i).showTitle(i + 1);
        }
    }

    protected void showTitle() throws MessageNotFoundException {
        String string = "\n" + this.title + "\n";
        for (int i = 0; i < this.title.length(); i++) {
            string += "-";
        }
        Console.getInstance().writeln(string);
    }

    protected void execChoosedOption() throws MessageNotFoundException, ClassNotFoundException, IOException {
        int answer;
        boolean ok;
        do {
            String msgAskOption = MessageManager.getInstance().getMessage("ASK_OPTION", this.options.size());
            answer = Console.getInstance().readInt(msgAskOption) - 1;

            ok = 0 <= answer && answer <= this.options.size() - 1;
            if (!ok) {
                MessageManager.getInstance().writeln("OPTION_ERROR");
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

    protected void setTitle(String title) {
        this.title = title;
    }

}
