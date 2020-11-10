package view;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Component;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.DateTimeProject;

public class FillDataGame extends JFrame {
	private JTextField txtNickname;
	private JTextField txtIDGamer;
	private JTextField txtPoints;
	private JTextField txtGame;
	public JTextField getTxtDateTime() {
		return txtDateTime;
	}

	public void setTxtDateTime(JTextField txtDateTime) {
		this.txtDateTime = txtDateTime;
	}

	private JTextField txtDateTime;

	private JButton btnSave;

	public FillDataGame() {

		JPanel p = new JPanel(new GridLayout(5, 2, 0, 0));

		JLabel lblIDGame = new JLabel("ID gamer:");
		p.add(lblIDGame);

		txtIDGamer = new JTextField("", 10);
		p.add(txtIDGamer);

		
		JLabel lblPoints = new JLabel("Points:");
		p.add(lblPoints);

		txtPoints = new JTextField("", 10);
		p.add(txtPoints);
		
		JLabel lblDate = new JLabel("Date:");
		p.add(lblDate);

				
		txtDateTime = new JTextField(DateTimeProject.getCurrentDate(), 10);
		p.add(txtDateTime);
		txtDateTime.setEditable(false);

		JLabel lblGame = new JLabel("Game:");
		p.add(lblGame);

		txtGame = new JTextField("", 10);
		p.add(txtGame);

		btnSave = new JButton("Save");
		p.add(btnSave);
		
		

		setContentPane(p);

		pack();
	}

	public JTextField getTxtNickname() {
		return txtNickname;
	}

	public void setTxtNickname(JTextField txtNickname) {
		this.txtNickname = txtNickname;
	}

	public JTextField getTxtIDGamer() {
		return txtIDGamer;
	}

	public void setTxtIDGamer(JTextField txtIDGamer) {
		this.txtIDGamer = txtIDGamer;
	}

	public JTextField getTxtPoints() {
		return txtPoints;
	}

	public void setTxtPoints(JTextField txtPoints) {
		this.txtPoints = txtPoints;
	}

	public JTextField getTxtGame() {
		return txtGame;
	}

	public void setTxtGame(JTextField txtGame) {
		this.txtGame = txtGame;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}
	
	

}
