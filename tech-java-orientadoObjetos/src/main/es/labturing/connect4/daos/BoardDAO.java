package main.es.labturing.connect4.daos;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import main.es.labturing.connect4.models.Board;
import main.es.labturing.connect4.models.Coordinate;
import main.es.labturing.connect4.types.Color;

class BoardDAO implements DAO {

	private Board board;

	BoardDAO(Board board) {
		this.board = board;
	}

	public void save(FileWriter fileWriter) {
		try {
			for (int i = 0; i < Coordinate.NUMBER_ROWS; i++) {
				for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
					fileWriter.write(this.board.getColor(new Coordinate(i, j)).toString() + "\n");
				}
			}
			if (this.board.getLastDrop() != null) {
				fileWriter.write(this.board.getLastDrop().getRow() + "." + this.board.getLastDrop().getColumn() + "\n");
			} else {
				fileWriter.write("-" + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(BufferedReader bufferedReader) {
		try {
			for (int i = 0; i < Coordinate.NUMBER_ROWS; i++) {
				for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
					String color = bufferedReader.readLine();
					this.board.setColor(Color.valueOf(color), new Coordinate(i, j));
				}
			}
			String lastDropCoordinate = bufferedReader.readLine();
			if ("-".equals(lastDropCoordinate)) {
				this.board.setLastDrop(null);
			} else {
				String[] coordinatesString = lastDropCoordinate.split("\\.");
				this.board.setLastDrop(new Coordinate(Integer.parseInt(coordinatesString[0]),
				Integer.parseInt(coordinatesString[1])));
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}