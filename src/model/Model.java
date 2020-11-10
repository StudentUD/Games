package model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.persistence.GameDTO;
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

	public DefaultTableModel fillDataTable() {

		Object[][] array = new Object[dataGames.size()][];

		int i = 0;
		for (GameDTO e : dataGames) {
			array[i] = new Object[5];
			
			int fk = e.getFk_idGamer(); 
			 GamerDTO  t = getGamer(fk);
			
			 //FIXME: Si no esta el regsitro en array
			 
			array[i][0] = fk;
			array[i][1] = t.getNickName();
			array[i][2] = e.getPoints();
			array[i][3] = e.getGame();
			array[i][4] = e.getDateOfGame();
			

			i++;
		}
		Object[] columnas = { "ID", "Nick Name ", "Points", "Game", "Date of Game"};

		DefaultTableModel df = new DefaultTableModel();

		df.setColumnIdentifiers(columnas);

		df.setDataVector(array, columnas);

		return df;
	}

	public GamerDTO search(int idGamer) {

		GamerDTO g = null;

		for (GamerDTO gamerDTO : dataGamers) {
			if (gamerDTO.getIdGamer() == idGamer) {
				g = gamerDTO;
			}
		}

		return g;
	}
	
	private  GamerDTO getGamer(int fk) {
		
		GamerDTO t = null; 
		
		for (GamerDTO gamerDTO : dataGamers) {
			if(gamerDTO.getIdGamer() == fk) {
				t =gamerDTO; 
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

	public void overideData(ArrayList<GamerDTO> a) {
		dataGamers = a;
	}

	public ArrayList<GamerDTO> getData() {
		return dataGamers;
	}

	public boolean isGamer(int id) {
		boolean isOnArray= false;
		for (GamerDTO gamerDTO : dataGamers) {
			if(gamerDTO.getIdGamer() == id) {isOnArray= true;}
			
			System.out.println("encuntra reptriod");
		}
		return isOnArray;
	}

}
