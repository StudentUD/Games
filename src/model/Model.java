package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.persistence.GameDAO;
import model.persistence.GameDTO;
import model.persistence.GamerDAO;
import model.persistence.GamerDTO;

public class Model {

	private ArrayList<GamerDTO> dataGamers;
	private ArrayList<GameDTO> dataGames;

	public Model() {
		dataGamers = new ArrayList<GamerDTO>();
		dataGames = new ArrayList<GameDTO>();
	}

	public void addGamer(GamerDTO g) {
		System.out.println(g.toString());
		dataGamers.add(g);

	}

	public void addGame(GameDTO g) {
		System.out.println(g.toString());
		dataGames.add(g);

	}

	public DefaultTableModel fillDataGamers() {

		Object[][] array = new Object[dataGamers.size()][];

		int i = 0;
		for (GamerDTO e : dataGamers) {
			array[i] = new Object[2];

			int id = e.getIdGamer();
			array[i][0] = id;
			array[i][1] = e.getNickName();

			i++;
		}
		Object[] columnas = { "ID", "Nick Name" };
		DefaultTableModel df = new DefaultTableModel();
		df.setColumnIdentifiers(columnas);
		df.setDataVector(array, columnas);
		return df;
	}

	public DefaultTableModel fillDataGames() {

		Object[][] array = new Object[dataGames.size()][];

		int i = 0;
		for (GameDTO e : dataGames) {
			array[i] = new Object[4];

			int fk = e.getFk_idGamer();

			array[i][0] = fk;

			array[i][1] = e.getPoints();
			array[i][2] = e.getGame();
			array[i][3] = e.getDateOfGame();

			i++;
		}
		Object[] columnas = { "ID", "Points", "Game", "Date of Game" };
		DefaultTableModel df = new DefaultTableModel();
		df.setColumnIdentifiers(columnas);
		df.setDataVector(array, columnas);
		return df;
	}

	public DefaultTableModel fillDataAll() {

		Object[][] array = new Object[dataGames.size()][];

		int i = 0;
		for (GameDTO e : dataGames) {
			array[i] = new Object[5];

			int fk = e.getFk_idGamer();
			GamerDTO t = getGamer(fk);

			// FIXME: Si no esta el regsitro en array

			array[i][0] = fk;
			array[i][1] = t.getNickName();
			array[i][2] = e.getPoints();
			array[i][3] = e.getGame();
			array[i][4] = e.getDateOfGame();

			i++;
		}
		Object[] columnas = { "ID", "Nick Name ", "Points", "Game", "Date of Game" };
		DefaultTableModel df = new DefaultTableModel();
		df.setColumnIdentifiers(columnas);
		df.setDataVector(array, columnas);
		return df;
	}

	// Funciones de Gammers
	public GamerDTO search(int idGamer) {

		GamerDTO g = null;

		for (GamerDTO gamerDTO : dataGamers) {
			if (gamerDTO.getIdGamer() == idGamer) {
				g = gamerDTO;
			}
		}

		return g;
	}

	private GamerDTO getGamer(int fk) {

		GamerDTO t = null;

		for (GamerDTO gamerDTO : dataGamers) {
			if (gamerDTO.getIdGamer() == fk) {
				t = gamerDTO;
			}
		}
		return t;
	}

	public GamerDTO get(int toUpdate) {
		GamerDTO g = null;

		for (int i = 0; i < dataGamers.size(); i++) {
			GamerDTO gamerDTO = dataGamers.get(i);

			if (gamerDTO.getIdGamer() == toUpdate) {
				g = gamerDTO;

				dataGamers.remove(i);
			}
		}

		return g;

	}

	public boolean isGamer(int id) {
		boolean isOnArray = false;
		for (GamerDTO gamerDTO : dataGamers) {
			if (gamerDTO.getIdGamer() == id) {
				isOnArray = true;
			}

			System.out.println("encuntra reptriod");
		}
		return isOnArray;
	}

	// funciones de logica
	public boolean saveAllGames() {
		GameDAO gDao = new GameDAO();
		return gDao.saveAll(dataGames);
	}

	public boolean saveAllGamers() {
		GamerDAO gDao = new GamerDAO();
		return gDao.saveAll(dataGamers);
	}

	public boolean saveLastGamer(GamerDTO d) {
		GamerDAO gDao = new GamerDAO();
		return gDao.saveLast(d, 2);
	}

	public GamerDTO loadLastGamer() {
		// TODO Auto-generated method stub
		GamerDAO dao = new GamerDAO();
		return dao.loadLast("Data", 2);

	}

	public int overideData() {
		int m = -1;
		try {
			GamerDAO dao = new GamerDAO();
			dataGamers = dao.loadAll();
		} catch (FileNotFoundException e) {
			m = 1;
		} catch (IOException e) {
			m = 1;
			e.printStackTrace();
		}

		try {
			GameDAO gDao = new GameDAO();
			dataGames = gDao.loadAll();

		} catch (FileNotFoundException e) {
			m = 0;
		} catch (IOException e) {
			m = 0;
			e.printStackTrace();
		}
		return m;
	}

}
