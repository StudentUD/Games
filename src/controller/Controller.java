package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.DateTimeProject;
import model.Model;
import model.persistence.GamerDTO;
import model.persistence.Game.GameDTO;
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
		
		
		
		// botones de repote
		v.getvPrincipal().getRbAll().addActionListener(ev);
		v.getvPrincipal().getRbGamers().addActionListener(ev);
		v.getvPrincipal().getRbGames().addActionListener(ev);
	}

	public class HandlerEvents implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			updateTableView();

			Object b = e.getSource();

			if (v.getvPrincipal().getBtnCreate() == b) {
				v.getvFillData().setVisible(true);
			}
			if (v.getvPrincipal().getBtnCreateGame() == b) {
				v.getvFillDataGame().setVisible(true);
			}
			if (v.getvPrincipal().getBtnUpdate() == b) {
				update();
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

		private void update() {
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

		private void saveGame() {
			int id = Integer.parseInt(v.getvFillDataGame().getTxtIDGamer().getText());
			int points = Integer.parseInt(v.getvFillDataGame().getTxtPoints().getText());
			String game = v.getvFillDataGame().getTxtGame().getText();
			String dt = v.getvFillDataGame().getTxtDateTime().getText();

			if (m.isGamer(id)) {
				// d es el contendor de la info

				GameDTO g = new GameDTO(id, DateTimeProject.parseLocalDateTime(dt), points, game);
				m.addGame(g);

				if (m.saveAllGames()) {
					JOptionPane.showMessageDialog(null, "Gamer saved");
				} else {
					JOptionPane.showMessageDialog(null, "Error");
				}
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

				if (m.saveLastGamer(d)) {
					JOptionPane.showMessageDialog(null, "Gamer saved");
				} else {
					JOptionPane.showMessageDialog(null, "Error");
				}

				m.saveAllGamers();
			} else {
				JOptionPane.showMessageDialog(null, "Duplicated ID");
			}

			updateTableView();

			v.getvFillData().setVisible(false);

			v.setvFillData(new FillData()); // creando ottro objeto por la ventana qyue tenia
			v.getvFillData().getBtnSave().addActionListener(this); // suscribo el evento a la nueva ventana Filldata
		}

		private void loadAllData() {
			int f = m.overideData();
			String me = null; 
			if (f == -1) {
				v.getvPrincipal().getRbAll().setSelected(true);
				me = "Load Games and Gamers";
			}
			
			if (f == 0) {
				
				v.getvPrincipal().getRbGamers().setSelected(true);
				me = " Not posible \n Error Load Games";
			}
			
			if (f == 1) {
				v.getvPrincipal().getRbGames().setSelected(true);
				me = "Not posible \n Load Gamers";
			}
			
			
			JOptionPane.showMessageDialog(null, me, "Information", JOptionPane.INFORMATION_MESSAGE, null);
		
			updateTableView();

		}

		private void loadFile() {
			GamerDTO t = m.loadLastGamer();

			m.addGamer(t);
			updateTableView();
		}

		private void updateTableView() {

			if (v.getvPrincipal().getRbAll().isSelected()) {
				v.getvPrincipal().getTabla().getTable().setModel(m.fillDataAll());
			}
			if (v.getvPrincipal().getRbGamers().isSelected()) {
				v.getvPrincipal().getTabla().getTable().setModel(m.fillDataGamers());
			}
			if (v.getvPrincipal().getRbGames().isSelected()) {
				v.getvPrincipal().getTabla().getTable().setModel(m.fillDataGames());
			}

		}
	}

}
