package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Game;
import main.es.labturing.connect4.views.console.MessageManager;
import main.es.labturing.connect4.views.console.TurnView;
import main.es.labturing.utils.views.YesNoDialog;

public class ResumeController extends Controller {

    public ResumeController(Game game) {
        super(game);
    }

    public boolean interact(TurnView turnView) {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(MessageManager.getInstance().getMessage("RESUME"));
        if (yesNoDialog.isAffirmative()) {
            this.game.reset();
            turnView.configTurn();
        }
        return yesNoDialog.isAffirmative();
    }

}
