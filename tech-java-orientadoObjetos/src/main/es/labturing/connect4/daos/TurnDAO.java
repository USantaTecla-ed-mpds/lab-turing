package main.es.labturing.connect4.daos;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import main.es.labturing.connect4.models.Turn;

class TurnDAO implements DAO {

    private Turn turn;

    TurnDAO(Turn turn) {
		this.turn = turn;
    }
    
    public void save(FileWriter fileWriter) {
		try {
			fileWriter.write(this.turn.getActivePlayerIndex() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(BufferedReader bufferedReader) {
		try {
			this.turn.setActivePlayerIndex(Integer.parseInt(bufferedReader.readLine()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
}