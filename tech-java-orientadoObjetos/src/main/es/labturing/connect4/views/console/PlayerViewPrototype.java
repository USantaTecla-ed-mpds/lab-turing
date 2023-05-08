package main.es.labturing.connect4.views.console;

import main.es.labturing.connect4.controllers.PlayController;
import main.es.labturing.connect4.controllers.UndoRedoController;
import main.es.labturing.connect4.types.PlayerType;

import java.util.HashMap;

public class PlayerViewPrototype {

    private HashMap<PlayerType, PlayerView> playerViewsMap;

    PlayerViewPrototype(PlayController playController, UndoRedoController undoRedoController) {
        this.playerViewsMap = new HashMap<>();
        this.playerViewsMap.put(PlayerType.HUMAN, new HumanPlayerView(playController, undoRedoController));
        this.playerViewsMap.put(PlayerType.RANDOM, new RandomPlayerView(playController));
        this.playerViewsMap.put(PlayerType.MINMAX, new MinMaxPlayerView(playController));
    }

    PlayerView createView(PlayerType playerType) {
        return  this.playerViewsMap.get(playerType);
    }
}
