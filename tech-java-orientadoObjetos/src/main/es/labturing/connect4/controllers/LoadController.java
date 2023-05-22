package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Session;

public class LoadController extends Controller{

    LoadController(Session session) {
        super(session);
    }

    public void load(){
        this.session.load();
        this.session.resetRegistry();
    }
    
}
