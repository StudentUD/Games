package model.persistence;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class GameDAO {

	public boolean saveAll(ArrayList<GameDTO> o) { // file Not foun IO Expecion

		boolean isOK = false;

		ObjectOutputStream salida;
		try {
			salida = new ObjectOutputStream(new FileOutputStream("./Data/DataGamesAll.obj"));
			salida.writeObject(o);
			salida.close();
			isOK = true;
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		return isOK;
	}

	public ArrayList<GameDTO> loadAll() throws FileNotFoundException, IOException { // file Not foun IO Expecion

		ArrayList<GameDTO> o = null;

		ObjectInputStream input;
			input = new ObjectInputStream(new FileInputStream("./Data/DataGamesAll.obj"));
			try {
				o =new ArrayList<GameDTO>();
						o = (ArrayList<GameDTO>) input.readObject(); 
			} catch (ClassNotFoundException e) {
				System.err.println("Class not found" + e.getMessage());
				e.printStackTrace();
			}
			input.close();
		return o;
	}
}
