package main.es.labturing.utils.views.menu;

public abstract class DynamicMenu extends IterativeMenu {

    public DynamicMenu(String title) {
        super(title);
    }

    @Override
    public void interact() {
        do {
            this.removeOptions();
            this.addOptions();
            this.interact_();
        } while (!this.isExecutedquitOption());
    }

}
