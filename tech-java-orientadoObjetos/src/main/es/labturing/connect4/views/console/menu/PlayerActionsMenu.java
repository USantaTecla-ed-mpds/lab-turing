package main.es.labturing.connect4.views.console.menu;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.views.console.PlayerView;
import main.es.labturing.utils.views.menu.Menu;

public class PlayerActionsMenu extends Menu{
    private UndoRedoController undoRedoController;
    private PlayController playController;
    private PlayerView playerView;

    public PlayerActionsMenu(UndoRedoController undoRedoController, PlayerView playerView, PlayController playController){
        super("A fuego SaveAndExit or Undo or Drop menu");
        this.undoRedoController = undoRedoController;
        this.playController = playController;
        this.playerView = playerView; 
    }

    @Override
    protected void addOptions(){
        //this.add(new SaveAndExitOption());
        this.add(new UndoOption(this.undoRedoController));
        this.add(new PlayOption(this.playController, this.playerView));
    }
}
