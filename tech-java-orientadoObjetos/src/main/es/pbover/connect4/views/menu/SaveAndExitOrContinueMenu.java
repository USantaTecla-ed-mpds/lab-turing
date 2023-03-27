package main.es.pbover.connect4.views.menu;

import main.es.pbover.connect4.models.GameManager;
import main.es.pbover.connect4.views.MessageManager;
import main.es.pbover.utils.menu.QuitMenu;
import main.es.pbover.utils.menu.QuitOption;

public class SaveAndExitOrContinueMenu extends QuitMenu{

    private GameManager gameManager;

    public SaveAndExitOrContinueMenu(GameManager gameManager) {
        super(MessageManager.getInstance().getMessage("SAVE_AND_EXIT_OR_CONTINUE_TITLE"));
        this.quitOption = new QuitOption(MessageManager.getInstance().getMessage("CONTINUE"));
        this.gameManager = gameManager;

    }
    @Override
    protected void addOptions(){
        this.add(new SaveAndExitOption(this.gameManager));
    }

}
