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
        super("Menu Guardar&Salir, undo/redo, o tirar");
        this.undoRedoController = undoRedoController;
        this.playController = playController;
        this.playerView = playerView; 
    }

    @Override
    protected void addOptions(){
        //this.add(new SaveAndExitOption(this.undoRedoController or this.playerActionsController)); //TODO: descomentar para dejar salvar y salir
        if(this.undoRedoController.isUndoable()){
            this.add(new UndoOption(this.undoRedoController));
        }
        if(this.undoRedoController.isRedoable()){
            this.add(new RedoOption(this.undoRedoController));
        }
        this.add(new PlayOption(this.playController, this.playerView));
    }
}
