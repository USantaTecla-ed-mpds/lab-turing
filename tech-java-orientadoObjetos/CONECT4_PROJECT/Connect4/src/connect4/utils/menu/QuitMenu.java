package connect4.utils.menu;

import connect4.utils.exceptions.MessageNotFoundException;

public abstract class QuitMenu extends Menu {

    private QuitOption quitOption;

    public QuitMenu(String title) throws MessageNotFoundException {
        super(title);
        this.quitOption = new QuitOption();
    }

    @Override
    protected void showTitles() throws MessageNotFoundException {
        this.addquitOption();
        super.showTitles();
    }

    protected void addquitOption() {
        if (!this.hasOption(this.quitOption)) {
            this.add(this.quitOption);
        }
    }
    

    protected boolean isExecutedquitOption() {
        return this.quitOption.isExecuted();
    }

}
