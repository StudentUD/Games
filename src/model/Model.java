package model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.persistence.GamerDTO;

public class Model {

	private ArrayList<GamerDTO> data;

	public Model() {
		data = new ArrayList<GamerDTO>();
	}

	public void addGamer(GamerDTO g) {
		System.out.println(g.toString());
		data.add(g);

	}

	public DefaultTableModel fillDataTable() {

		Object[][] array = new Object[data.size()][];

		int i = 0;
		for (GamerDTO e : data) {
			array[i] = new Object[4];
			array[i][0] = e.getIdGamer();
			array[i][1] = e.getNickName();
			array[i][2] = e.getPoints();
			array[i][3] = e.getGame();
			i++;
		}
		Object[] columnas = { "ID", "Nick Name ", "Points", "Game" };

		DefaultTableModel df = new DefaultTableModel();

		df.setColumnIdentifiers(columnas);

		df.setDataVector(array, columnas);

		return df;
	}

	public GamerDTO search(int idGamer) {

		GamerDTO g = null;

		for (GamerDTO gamerDTO : data) {
			if (gamerDTO.getIdGamer() == idGamer) {
				g = gamerDTO;
			}
		}

		return g;
	}

	public GamerDTO get(int toUpdate) {
		GamerDTO g = null;

		for (int i = 0; i < data.size(); i++) {
			GamerDTO gamerDTO = data.get(i);

			if (gamerDTO.getIdGamer() == toUpdate) {
				g = gamerDTO;

				data.remove(i);
			}
		}

		return g;

	}

	public void overideData(ArrayList<GamerDTO> a) {
		data = a;
	}

	public ArrayList<GamerDTO> getData() {
		return data;
	}

}
