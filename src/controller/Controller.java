package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Model;
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
		v.getvPrincipal().getBtnUpdate().addActionListener(ev);

		v.getvPrincipal().getBtnDelete().addActionListener(ev);

		v.getvPrincipal().getBtnRead().addActionListener(ev);

		v.getvPrincipal().getBtnLoad().addActionListener(ev);

		// coloca los otrso botones

		v.getvFillData().getBtnSave().addActionListener(ev);
	}

	public class HandlerEvents implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Object b = e.getSource();

			if (v.getvPrincipal().getBtnCreate() == b) {
				v.getvFillData().setVisible(true);
			}

			if (v.getvPrincipal().getBtnUpdate() == b) {

				int toUpdate = Integer.parseInt(JOptionPane.showInputDialog("Enter ID gamer"));

				GamerDTO g = m.get(toUpdate);
				if (g != null) {
					v.getvFillData().setVisible(true);
					v.getvFillData().getTxtIDGamer().setText(String.valueOf(g.getIdGamer()));
					v.getvFillData().getTxtNickname().setText(g.getNickName());
					v.getvFillData().getTxtPoints().setText(String.valueOf(g.getPoints()));
					v.getvFillData().getTxtGame().setText(g.getGame());

				} else {

					JOptionPane.showMessageDialog(null, "Not found ID");
				}

			}

			if (v.getvFillData().getBtnSave() == b) {
				// trae la infoemacion del fill data
				System.out.println("Datos " + v.getvFillData().getTxtNickname().getText());

				// d es el contendor de la info
				GamerDTO d = new GamerDTO(v.getvFillData().getTxtNickname().getText(),
						Integer.parseInt(v.getvFillData().getTxtIDGamer().getText()),
						Integer.parseInt(v.getvFillData().getTxtPoints().getText()),
						v.getvFillData().getTxtGame().getText());

				// lo alamceno en logica de palicacion
				m.addGamer(d);
				v.getvPrincipal().getTabla().getTable().setModel(m.fillDataTable());

				v.getvFillData().setVisible(false);
				v.setvFillData(new FillData()); // creando ottro objeto por la ventana qyue tenia
				v.getvFillData().getBtnSave().addActionListener(this); // suscribo el evento a la nueva ventana Filldata

				// transacciones
				GamerDAO dao = new GamerDAO();
				if (dao.save(d, 2)) {
					JOptionPane.showMessageDialog(null, "Gamer saved");
				} else {
					JOptionPane.showMessageDialog(null, "Error");
				}

				dao.save(m.getData());

			}

			if (v.getvPrincipal().getBtnLoad() == b) {

				// loadFile();

				loadAllData();

			}

			if (v.getvPrincipal().getBtnRead() == b) {

				loadFile();

			}

			if (v.getvPrincipal().getBtnDelete() == b) {

				int toDelete = Integer.parseInt(JOptionPane.showInputDialog("Enter ID gamer"));

				GamerDTO g = m.get(toDelete);
				if (g != null) {
					JOptionPane.showMessageDialog(null, "Deleted ID");
				} else {

					JOptionPane.showMessageDialog(null, "Not found ID");
				}

				v.getvPrincipal().getTabla().getTable().setModel(m.fillDataTable());

			}

		}

		private void loadAllData() {
			GamerDAO dao = new GamerDAO();
			m.overideData(dao.loadAll());
			v.getvPrincipal().getTabla().getTable().setModel(m.fillDataTable());

		}

		private void loadFile() {
			GamerDAO dao = new GamerDAO();
			GamerDTO t = dao.load("Data", 2);

			m.addGamer(t);
			v.getvPrincipal().getTabla().getTable().setModel(m.fillDataTable());

		}

	}

}
