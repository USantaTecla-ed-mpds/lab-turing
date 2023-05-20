package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.RedoController;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.utils.views.menu.QuitMenu;
import main.es.labturing.utils.views.menu.QuitOption;

public class SaveAndExitOrContinueMenu extends QuitMenu{

    private RedoController undoRedoController;

    public SaveAndExitOrContinueMenu(RedoController undoRedoController) {
        super(MessageManager.getInstance().getMessage("SAVE_AND_EXIT_OR_CONTINUE_TITLE"));
        this.quitOption = new QuitOption(MessageManager.getInstance().getMessage("CONTINUE"));
        this.undoRedoController = undoRedoController;

    }
    @Override
    protected void addOptions(){
        //this.add(new SaveAndExitOption(this.undoRedoController));
    }

}
