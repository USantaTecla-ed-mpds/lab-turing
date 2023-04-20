package main.es.labturing.connect4.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameManager_old {

    private Turn turn;
    private Board board;

    private final String path = "tech-java-orientadoObjetos/src/main/es/pbover/connect4/resources/";

    public GameManager_old(Board board, Turn turn) {
        this.board = board;
        this.turn = turn;
    }

    public void save() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(this.path + "savedgame.dat"));
            oos.writeObject(this.board);
            oos.writeObject(this.turn);
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

    public void load()  {
        ObjectInputStream ois = null;
        try  {
            ois = new ObjectInputStream(new FileInputStream(this.path + "savedgame.dat"));
         //   connect4.setBoard((Board) ois.readObject());
          //  connect4.setTurn((Turn) ois.readObject());
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                  System.out.println("IOException al cerrar: " + ex.getMessage());
                }
            }
        }

    }
}
