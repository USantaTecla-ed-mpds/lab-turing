package main.es.labturing.connect4.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class GameManager {

    List<GameState> gameStates;
    private int firstPrevious;
    private final String path = "tech-java-orientadoObjetos/src/main/es/pbover/connect4/resources/";

    public GameManager() {
        this.firstPrevious = 0;
        this.gameStates = new ArrayList<GameState>();
    }

    public void registry(Game game) {
        for (int i = 0; i < this.firstPrevious; i++) {
            this.gameStates.remove(0);
        }
        this.firstPrevious = 0;
        this.gameStates.add(this.firstPrevious, game.getState());

    }

    public GameState getUndoneState() {
        this.firstPrevious++;
        return this.gameStates.get(firstPrevious);
    }

    public GameState getRedoneState() {
        this.firstPrevious--;
        return this.gameStates.get(firstPrevious);

    }

    public boolean isUndoable() {
        return this.firstPrevious < this.gameStates.size() - 1;
    }

    public boolean isRedoable() {
        return this.firstPrevious >= 1;
    }

    public void save() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(this.path +
                    "savedgame.dat"));
            oos.writeObject(this.gameStates.get(firstPrevious));
           
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

    public void load(Game game) {
        ObjectInputStream ois = null;
        GameState gameState = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(this.path +
                    "savedgame.dat"));
            gameState = (GameState) ois.readObject();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                    game.setState(gameState);
                } catch (IOException ex) {
                    System.out.println("IOException al cerrar: " + ex.getMessage());
                }
            }
        }
    }

}
