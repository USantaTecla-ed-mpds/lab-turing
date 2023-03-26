package connect4.utils.menu;

import connect4.utils.exceptions.MessageNotFoundException;

public abstract class SimpleMenu extends Menu {

    public SimpleMenu(String title) throws MessageNotFoundException {
        super(title);

    }

    @Override
    protected void showTitles() throws MessageNotFoundException {
        this.addquitOption();
        super.showTitles();
    }

    protected void addquitOption() {
    }

}
