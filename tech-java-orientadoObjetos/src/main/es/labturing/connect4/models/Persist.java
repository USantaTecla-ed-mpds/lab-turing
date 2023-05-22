package main.es.labturing.connect4.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persist {

    private final String path = "tech-java-orientadoObjetos/src/main/es/labturing/connect4/resources/";
    private Game game;

    public Persist(Game game){
        this.game = game;
    }
    
    public void save(GameState gameState) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(this.path + "savedgame.dat"));
            oos.writeObject(gameState);
           
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    System.out.println("IOException al cerrar: " + ex.getMessage());
                }
            }
        }
    }

    public void load() {
        ObjectInputStream ois = null;
        GameState gameState = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(this.path + "savedgame.dat"));
            gameState = (GameState) ois.readObject();
        } catch (Exception e) {
            System.out.println("EXCEPCION: " + e.getMessage());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                    this.game.setState(gameState);
                } catch (IOException ex) {
                    System.out.println("IOException al cerrar: " + ex.getMessage());
                }
            }
        }
    }

    public boolean isGamePersisted(){
        File file = new File(this.path + "savedgame.dat");
        return file.exists();
    }
}
