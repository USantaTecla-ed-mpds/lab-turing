package main.es.labturing.connect4.views.menu;

import main.es.labturing.connect4.models.GameManager_old;
import main.es.labturing.connect4.views.MessageManager;
import main.es.labturing.utils.views.menu.QuitMenu;
import main.es.labturing.utils.views.menu.QuitOption;

public class SaveAndExitOrContinueMenu extends QuitMenu{

    private GameManager_old gameManager;

    public SaveAndExitOrContinueMenu(GameManager_old gameManager) {
        super(MessageManager.getInstance().getMessage("SAVE_AND_EXIT_OR_CONTINUE_TITLE"));
        this.quitOption = new QuitOption(MessageManager.getInstance().getMessage("CONTINUE"));
        this.gameManager = gameManager;

    }
    @Override
    protected void addOptions(){
        this.add(new SaveAndExitOption(this.gameManager));
    }

}
