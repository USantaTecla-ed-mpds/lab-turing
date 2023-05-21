package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Session;

public class SaveController extends Controller{

    SaveController(Session session) {
        super(session);
    }

    public void save(){
        this.session.save();
    } 
    
}
