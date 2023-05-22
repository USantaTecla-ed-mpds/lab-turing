package main.es.labturing.connect4.controllers;

import main.es.labturing.connect4.models.Session;

public class DropTokenController extends Controller{

    DropTokenController(Session session) {
        super(session);
    }

    public void dropToken(int column) {
        this.session.dropToken(column);
        this.session.registry();
    } 


}
