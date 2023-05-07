package main.es.labturing.connect4.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private List<GameState> gameStates;
    private static GameManager instance = null;
    private int firstPrevious;
    private boolean firstState;
    private final String path = "tech-java-orientadoObjetos/src/main/es/pbover/connect4/resources/";

    private GameManager() {
        this.gameStates = new ArrayList<>();
        this.firstPrevious = 1;
        this.firstState = false;
    }

    public static GameManager getInstance() {
        if (GameManager.instance == null) {
            GameManager.instance = new GameManager();
        }
        return GameManager.instance;
    }

    public void registry(GameState gameState) {
        this.firstState = true;
        if (this.firstPrevious == 1) {
            this.gameStates.add(0, gameState);
        } else {
            for (int i = 0; i < this.firstPrevious - 1; i++) {
                this.gameStates.remove(0);
            }
            this.gameStates.add(0, gameState);
            this.firstPrevious = 1;
        }
        //this.trazaMetodoParaBorrar();
    }

    private void trazaMetodoParaBorrar() {
        int counter = 0;
        System.out.println("SIZE: " + this.gameStates.size());
        for (GameState element : this.gameStates) {
            System.out.println(" Memento numero " + counter++ + " " + element);
            for (int i = 0; i < element.getBoardState().getColors().length; i++) {
                for (int j = 0; j < element.getBoardState().getColors()[i].length; j++) {
                    System.out.print(" " + element.getBoardState().getColors()[i][j]);
                }
                System.out.println("");
            }
        }
    }

    public GameState getUndoneState() {
        GameState gameState = new GameState(this.gameStates.get(this.firstPrevious).clone());
        this.firstPrevious++;
        return gameState;
    }

    public GameState getRedoneState() {
        this.firstPrevious--;
        GameState gameState = new GameState(this.gameStates.get(this.firstPrevious - 1).clone());
        return gameState;
    }

    public void save() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(this.path + "savedgame.dat"));
            oos.writeObject(this.gameStates.get(0).getBoardState());
            oos.writeObject(this.gameStates.get(0).getTurnState());
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

    public GameState load() {
        ObjectInputStream ois = null;
        BoardState boardState = null;
        TurnState turnState = null;
        GameState gameState = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(this.path + "savedgame.dat"));
            boardState = (BoardState) ois.readObject();
            turnState = (TurnState) ois.readObject();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                    gameState = new GameState(boardState, turnState);
                } catch (IOException ex) {
                    System.out.println("IOException al cerrar: " + ex.getMessage());
                }
            }
        }
        return gameState;
    }

    public boolean isUndoable() {
        return this.firstPrevious >= 1 && this.firstState;
    }

    public boolean isRedoable() {
        return this.firstPrevious > 1;
    }

}
