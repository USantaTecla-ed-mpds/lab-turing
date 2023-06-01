package main.es.labturing.connect4.daos;

import java.io.BufferedReader;
import java.io.FileWriter;

interface DAO {

	void save (FileWriter fileWriter);
	
	void load (BufferedReader bufferedReader);
	
}
