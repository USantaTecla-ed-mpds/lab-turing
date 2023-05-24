package main.es.labturing.connect4.storage;

public interface Storage {

    void save();

    void load();

    boolean isGamePersisted();
    
}
