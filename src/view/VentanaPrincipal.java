package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class VentanaPrincipal extends JFrame {

	// declaro
	private JButton btnCreate;
	private JButton btnCreateGame; 
	private JButton btnUpdate;
	private JButton btnRead;
	private JButton btnDelete;
	private JButton btnLoad;

	private Table tabla;
	private JRadioButton rbGames;
	private JRadioButton rbGamers;
	private JRadioButton rbAll;

	public VentanaPrincipal() {

		JPanel pButtons = new JPanel();

		setTitle("Gamers");
		BoxLayout bl = new BoxLayout(pButtons, BoxLayout.X_AXIS);
		pButtons.setLayout(bl);

		// iniclizar y añado al panel
		btnCreate = new JButton("Create Gamer");
		pButtons.add(btnCreate);
		
		btnCreateGame = new JButton("Create game");
		pButtons.add(btnCreateGame);


		btnUpdate = new JButton("Update");
		pButtons.add(btnUpdate);

		btnRead = new JButton("Read / Report");
		pButtons.add(btnRead);

		btnDelete = new JButton("Delete");
		pButtons.add(btnDelete);

		btnLoad = new JButton("Load Gamers");
		pButtons.add(btnLoad);

		JPanel panel = new JPanel(new BorderLayout());
		panel.add(pButtons, BorderLayout.NORTH);

		tabla = new Table();
		panel.add(tabla, BorderLayout.CENTER);
		
		JPanel rbButton = new JPanel(); 
		rbGames = new JRadioButton("Games");
		rbButton.add(rbGames); 
		
		rbGamers = new JRadioButton("Gamers");
		rbButton.add(rbGamers);
		rbAll = new JRadioButton("All data");
		rbButton.add(rbAll); 
		
		panel.add(rbButton,BorderLayout.SOUTH);
		

		ButtonGroup grb = new ButtonGroup(); 
		grb.add(rbGames);
		grb.add(rbGamers);
		grb.add(rbAll);
		

		setContentPane(panel);

		pack();

	}

	public JButton getBtnCreate() {
		return btnCreate;
	}
	public JButton getBtnCreateGame() {
		return btnCreateGame;
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

	public JRadioButton getRbGames() {
		return rbGames;
	}

	public void setRbGames(JRadioButton rbGames) {
		this.rbGames = rbGames;
	}

	public JRadioButton getRbGamers() {
		return rbGamers;
	}

	public void setRbGamers(JRadioButton rbGamers) {
		this.rbGamers = rbGamers;
	}

	public JRadioButton getRbAll() {
		return rbAll;
	}

	public void setRbAll(JRadioButton rbAll) {
		this.rbAll = rbAll;
	}

	
	
}
