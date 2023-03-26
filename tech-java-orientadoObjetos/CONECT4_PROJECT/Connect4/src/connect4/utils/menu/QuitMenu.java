package connect4.utils.menu;

import connect4.utils.exceptions.MessageNotFoundException;

public abstract class QuitMenu extends Menu {

    public QuitMenu(String title) throws MessageNotFoundException {
        super(title);

    }

    @Override
    protected void showTitles() throws MessageNotFoundException {
        this.addQuitOption();
        super.showTitles();
    }

    protected void addQuitOption() throws MessageNotFoundException {
    }

}
