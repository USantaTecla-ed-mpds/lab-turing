package main.es.labturing.connect4.daos;

import java.io.BufferedReader;
import java.io.FileOutputStream;

interface DAO {

	void save (FileOutputStream fileOutputStream);
	
	void load (BufferedReader bufferedReader);
	
}
