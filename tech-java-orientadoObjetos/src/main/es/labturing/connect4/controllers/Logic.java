package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Session;
import main.es.labturing.connect4.models.StageValue;
import main.es.labturing.utils.framework.AcceptorController;

import java.util.HashMap;
import java.util.Map;

public class Logic implements main.es.labturing.utils.framework.Logic {

    private Session session;
    private Map<StageValue, AcceptorController> controllers;

    public Logic() {
        this.session = new Session();
        this.controllers = new HashMap<>();
        this.controllers.put(StageValue.INITIAL, new StartController(this.session));
        this.controllers.put(StageValue.IN_GAME, new PlayController(this.session));
        this.controllers.put(StageValue.RESUME, new ResumeController(this.session));
        this.controllers.put(StageValue.EXIT, null);
    }

    public AcceptorController getController() {
        return this.controllers.get(this.session.getValueStage());
    }

}
