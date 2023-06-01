package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.daos.SessionDAO;
import main.es.labturing.connect4.models.Session;
import main.es.labturing.connect4.types.StageValue;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    private Session session;
    private SessionDAO sessionDAO;
    private Map<StageValue, AcceptorController> controllers;

    public Logic(SessionDAO sessionDAO) {
        this.session = new Session();
        this.sessionDAO = sessionDAO;
        this.controllers = new HashMap<>();
        this.controllers.put(StageValue.INITIAL, new StartController(this.session, this.sessionDAO));
        this.controllers.put(StageValue.IN_GAME, new PlayController(this.session));
        this.controllers.put(StageValue.SAVE, new SaveController(this.session, this.sessionDAO));
        this.controllers.put(StageValue.RESUME, new ResumeController(this.session));
        this.controllers.put(StageValue.EXIT, null);
    }

    public AcceptorController getController() {
        return this.controllers.get(this.session.getValueStage());
    }

}
