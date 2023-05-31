package main.es.labturing.connect4.daos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import main.es.labturing.connect4.models.Session;
import main.es.labturing.connect4.types.StageValue;

public class SessionDAO {

	public static final String EXTENSION = ".mm";

	public static final String DIRECTORY = "./partidas";

	private static File directory;

	static {
		SessionDAO.directory = new File(SessionDAO.DIRECTORY);
		if (!SessionDAO.directory.exists()) {
			SessionDAO.directory.mkdirs();
		}
	}

	private Session session;

	private GameDAO gameDAO;

	public void associate(Session session) {
		this.session = session;
		this.gameDAO = new GameDAO(this.session.getGame());
	}

	public void load(String name) {
		this.session.setName(name);
		File file = new File(SessionDAO.directory, name);
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			this.gameDAO.load(bufferedReader);
			this.session.resetRegistry();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.session.setStageValue(StageValue.IN_GAME);
		if (this.session.isGameFinished()) {
			this.session.setStageValue(StageValue.RESUME);
		}
	}

	public void save() {
		this.save(this.session.getName());
	}

	public void save(String name) {
		if (name.endsWith(SessionDAO.EXTENSION)) {
			name = name.replace(SessionDAO.EXTENSION, "");
		}
		File file = new File(SessionDAO.directory, name + SessionDAO.EXTENSION);
		try {
			FileWriter fileWriter = new FileWriter(file);
			this.gameDAO.save(fileWriter);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] getGamesNames() {
		return SessionDAO.directory.list();
	}

	public boolean exists(String name) {
			for (String auxName : this.getGamesNames()) {
				if (auxName.equals(name + SessionDAO.EXTENSION)) {
					return true;
				}
			}
		return false;
	}

}