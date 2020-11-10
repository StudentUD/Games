package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.DateTimeProject;
import model.Model;
import model.persistence.GameDTO;
import model.persistence.GamerDAO;
import model.persistence.GamerDTO;
import view.FillData;
import view.View;

public class Controller {

	private Model m;
	private View v;

	public Controller(Model m, View v) {
		this.m = m;
		this.v = v;


		v.getvPrincipal().setVisible(true);

		HandlerEvents ev = new HandlerEvents();

		v.getvPrincipal().getBtnCreate().addActionListener(ev);
		v.getvPrincipal().getBtnCreateGame().addActionListener(ev);
		v.getvPrincipal().getBtnUpdate().addActionListener(ev);

		v.getvPrincipal().getBtnDelete().addActionListener(ev);

		v.getvPrincipal().getBtnRead().addActionListener(ev);

		v.getvPrincipal().getBtnLoad().addActionListener(ev);

		// coloca los otrso botones

		v.getvFillData().getBtnSave().addActionListener(ev);
		v.getvFillDataGame().getBtnSave().addActionListener(ev);
	}

	public class HandlerEvents implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Object b = e.getSource();

			if (v.getvPrincipal().getBtnCreate() == b) {
				v.getvFillData().setVisible(true);
			}
			if (v.getvPrincipal().getBtnCreateGame() == b) {
				v.getvFillDataGame().setVisible(true);
			}

			if (v.getvPrincipal().getBtnUpdate() == b) {
				int toUpdate = Integer.parseInt(JOptionPane.showInputDialog("Enter ID gamer"));

				GamerDTO g = m.get(toUpdate);
				if (g != null) {
					v.getvFillData().setVisible(true);
					v.getvFillData().getTxtIDGamer().setText(String.valueOf(g.getIdGamer()));
					v.getvFillData().getTxtNickname().setText(g.getNickName());
				} else {

					JOptionPane.showMessageDialog(null, "Not found ID");
				}
			}

			if (v.getvFillData().getBtnSave() == b) {
				saveGamer(); 
			}
			
			if (v.getvFillDataGame().getBtnSave() == b) {
				saveGame(); 
			}

			if (v.getvPrincipal().getBtnLoad() == b) {

				// loadFile();

				loadAllData();
				

			}

			if (v.getvPrincipal().getBtnRead() == b) {

				updateTableView();

			}

			if (v.getvPrincipal().getBtnDelete() == b) {

				int toDelete = Integer.parseInt(JOptionPane.showInputDialog("Enter ID gamer"));

				GamerDTO g = m.get(toDelete);
				if (g != null) {
					JOptionPane.showMessageDialog(null, "Deleted ID");
				} else {

					JOptionPane.showMessageDialog(null, "Not found ID");
				}

				updateTableView();

			}

		}

		private void saveGame() {
			int id = Integer.parseInt(v.getvFillDataGame().getTxtIDGamer().getText()); 
			int points = Integer.parseInt(v.getvFillDataGame().getTxtPoints().getText()); 
			String game = v.getvFillDataGame().getTxtGame().getText(); 
			 String dt = v.getvFillDataGame().getTxtDateTime().getText(); 
			
			if (m.isGamer(id)) {
				// d es el contendor de la info
				
				
				GameDTO g = new GameDTO(id,DateTimeProject.parseLocalDateTime(dt),points,  game);
				m.addGame(g);

				/* transacciones
				GamerDAO dao = new GamerDAO();
				if (dao.save(d, 2)) {
					JOptionPane.showMessageDialog(null, "Gamer saved");
				} else {
					JOptionPane.showMessageDialog(null, "Error");
				}

				dao.save(m.getData());
				
				*/
			} else {
				JOptionPane.showMessageDialog(null, "No found iD");
			}

			updateTableView();

			v.getvFillDataGame().setVisible(false);

			v.setvFillData(new FillData()); // creando ottro objeto por la ventana qyue tenia
			v.getvFillData().getBtnSave().addActionListener(this); // suscribo el evento a la nueva ventana Filldata
		
			
		}

		private void saveGamer() {
			// trae la infoemacion del fill data
			
			
			
			
			int id = Integer.parseInt(v.getvFillData().getTxtIDGamer().getText()); 
			String nickName = v.getvFillData().getTxtNickname().getText(); 

			
			if (!m.isGamer(id)) {
				
				// d es el contendor de la info
				GamerDTO d = new GamerDTO(nickName, id);
				m.addGamer(d);

				// transacciones
				GamerDAO dao = new GamerDAO();
				if (dao.save(d, 2)) {
					JOptionPane.showMessageDialog(null, "Gamer saved");
				} else {
					JOptionPane.showMessageDialog(null, "Error");
				}

				dao.save(m.getData());
			} else {
				JOptionPane.showMessageDialog(null, "Duplicated ID");
			}

			updateTableView();

			v.getvFillData().setVisible(false);

			v.setvFillData(new FillData()); // creando ottro objeto por la ventana qyue tenia
			v.getvFillData().getBtnSave().addActionListener(this); // suscribo el evento a la nueva ventana Filldata

		}


		private void loadAllData() {
			GamerDAO dao = new GamerDAO();
			m.overideData(dao.loadAll());
			v.getvPrincipal().getRbGamers().setSelected(true);
			updateTableView();

		}

		private void loadFile() {
			GamerDAO dao = new GamerDAO();
			GamerDTO t = dao.load("Data", 2);

			m.addGamer(t);
			updateTableView();

		}

		
		private void updateTableView() {
			
			if(v.getvPrincipal().getRbAll().isSelected()) {
			v.getvPrincipal().getTabla().getTable().setModel(m.fillDataAll());
			}
			if(v.getvPrincipal().getRbGamers().isSelected()) {
				v.getvPrincipal().getTabla().getTable().setModel(m.fillDataGamers());
				}
			if(v.getvPrincipal().getRbGames().isSelected()) {
				v.getvPrincipal().getTabla().getTable().setModel(m.fillDataGames());
				}
			
		}
	}
	
	

}
