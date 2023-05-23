package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Session;

public class SaveAndExitController extends Controller{

    SaveAndExitController(Session session) {
        super(session);
    }

    public void save(){
        this.session.save();
        this.session.nextStage();
    } 
    
}
