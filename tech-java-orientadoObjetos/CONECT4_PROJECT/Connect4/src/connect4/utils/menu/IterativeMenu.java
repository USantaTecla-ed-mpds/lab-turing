package connect4.utils.menu;

public abstract class IterativeMenu extends QuitMenu {

    public IterativeMenu(String title) {
        super(title);
    }

    @Override
    public void interact() {
        this.addOptions();
        do {
            this.interact_();
        } while (!this.isExecutedquitOption());
    }

}
