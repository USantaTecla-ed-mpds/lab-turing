package main.es.labturing.connect4.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import main.es.labturing.connect4.models.Game;
import main.es.labturing.connect4.models.Session;

public class LocalStorage implements Storage{

    private final String path = "tech-java-orientadoObjetos/src/main/es/labturing/connect4/resources/";
    private Session session;

    public LocalStorage(Session session){
        this.session = session;
    }
    
    public void save() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(this.path + "savedgame.dat"));
            oos.writeObject(this.session.getGame());
           
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
        Game game = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(this.path + "savedgame.dat"));
            game = (Game) ois.readObject();
        } catch (Exception e) {
            System.out.println("EXCEPCION: " + e.getMessage());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                    this.session.setGame(game);
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
