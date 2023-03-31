package main.es.labturing.utils.views.menu;

public abstract class QuitMenu extends Menu {

    protected QuitOption quitOption;

    public QuitMenu(String title) {
        super(title);
        this.quitOption = new QuitOption();
    }

    @Override
    protected void showTitles() {
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
