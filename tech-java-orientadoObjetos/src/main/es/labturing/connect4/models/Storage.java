package main.es.labturing.connect4.models;

public interface Storage {

    void save();

    void load();

    boolean isGamePersisted();
    
}
