package main.es.labturing.connect4.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

public class GameManager {

    Stack<GameState> gameStates = new Stack<GameState>();
    private static GameManager instance = null;
    private int firstPrevious = 0;
    private final String path = "tech-java-orientadoObjetos/src/main/es/pbover/connect4/resources/";

    private GameManager() {
    }

    public static GameManager getInstance() {
        if (GameManager.instance == null) {
            GameManager.instance = new GameManager();
        }
        return GameManager.instance;
    }

    public void registry(GameState gameState) {
        //aquí va el bucle for
        this.gameStates.add(gameState);
        this.firstPrevious++;
        // TRAZA//
        int counter = 0;
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

    public GameState getUndoneState(){
        System.out.println("firstPrevious: " + this.firstPrevious);
        this.firstPrevious--;
        return this.gameStates.get(firstPrevious - 1);
    }

    public void redo(){}

    public void save(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(this.path + "savedgame.dat"));
            // oos.writeObject(this.board);
            // oos.writeObject(this.turn);
            oos.writeObject(this.gameStates.peek().getBoardState());
            oos.writeObject(this.gameStates.peek().getTurnState());
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

    public GameState load()  {
        ObjectInputStream ois = null;
        BoardState boardState = null;
        TurnState turnState = null;
        GameState gameState = null;
        try  {
            ois = new ObjectInputStream(new FileInputStream(this.path + "savedgame.dat"));
        //    connect4.setBoard((Board) ois.readObject());
        //    connect4.setTurn((Turn) ois.readObject());
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
		return this.firstPrevious < this.gameStates.size() - 1;
	}

	public boolean isRedoable() {
		return this.firstPrevious >= 1;
	}
    
}
