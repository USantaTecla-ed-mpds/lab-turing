package main.es.labturing.connect4.daos;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import main.es.labturing.connect4.models.Turn;
import main.es.labturing.connect4.types.PlayerType;

class TurnDAO implements DAO {

    private Turn turn;

    TurnDAO(Turn turn) {
		this.turn = turn;
    }
    
    public void save(FileWriter fileWriter) {
		try {
			fileWriter.write(this.turn.getActivePlayerIndex() + "\n");
			for (int i = 0; i < Turn.NUMBER_PLAYERS ; i++) {
				fileWriter.write(this.turn.getPlayerType(i) + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(BufferedReader bufferedReader) {
		try {
			this.turn.resetPlayers();
			this.turn.setActivePlayerIndex(Integer.parseInt(bufferedReader.readLine()));
			for (int i = 0; i < Turn.NUMBER_PLAYERS ; i++) {
				this.turn.addPlayer(PlayerType.values()[Integer.parseInt(bufferedReader.readLine())]);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
}