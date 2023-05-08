package main.es.labturing.connect4.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class GameManager {

    List<GameState> gameStates = new ArrayList<GameState>();
    private Game game;
    private int firstPrevious = 0;
    private final String path = "tech-java-orientadoObjetos/src/main/es/pbover/connect4/resources/";

    public GameManager(Game game) {
        this.game = game;
    }

    public void registry() {
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
            // oos.writeObject(this.board);
            // oos.writeObject(this.turn);
            oos.writeObject(this.gameStates.get(firstPrevious).getBoardState());
            oos.writeObject(this.gameStates.get(firstPrevious).getTurnState());
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
            ois = new ObjectInputStream(new FileInputStream(this.path +
                    "savedgame.dat"));
            // connect4.setBoard((Board) ois.readObject());
            // connect4.setTurn((Turn) ois.readObject());
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

}
