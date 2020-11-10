package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {

	// declaro
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnRead;
	private JButton btnDelete;
	private JButton btnLoad;

	private Table tabla;

	public VentanaPrincipal() {

		JPanel pButtons = new JPanel();

		setTitle("Gamers");
		BoxLayout bl = new BoxLayout(pButtons, BoxLayout.X_AXIS);
		pButtons.setLayout(bl);

		// iniclizar y añado al panel
		btnCreate = new JButton("Create");
		pButtons.add(btnCreate);

		btnUpdate = new JButton("Update");
		pButtons.add(btnUpdate);

		btnRead = new JButton("Read");
		pButtons.add(btnRead);

		btnDelete = new JButton("Delete");
		pButtons.add(btnDelete);

		btnLoad = new JButton("Load");
		pButtons.add(btnLoad);

		JPanel panel = new JPanel(new BorderLayout());
		panel.add(pButtons, BorderLayout.NORTH);

		tabla = new Table();
		panel.add(tabla, BorderLayout.CENTER);

		setContentPane(panel);

		pack();

	}

	public JButton getBtnCreate() {
		return btnCreate;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public JButton getBtnRead() {
		return btnRead;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnLoad() {
		return btnLoad;
	}

	public Table getTabla() {
		return tabla;
	}

}
