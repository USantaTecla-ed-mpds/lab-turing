package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.utils.views.menu.Option;

public class GameSelectedOption extends Option{

    private StartController startController;

    public GameSelectedOption(String title, StartController startController) {
        super(title);
        this.startController = startController;
    }

    @Override
    public void interact() {
        this.startController.load(this.title);
        this.startController.start();
    }

    
}
