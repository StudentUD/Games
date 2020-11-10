package view;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FillData extends JFrame {
	private JTextField txtNickname;
	private JTextField txtIDGamer;


	private JButton btnSave;

	public FillData() {

		JPanel p = new JPanel(new GridLayout(5, 2, 0, 0));

		JLabel lblIDGame = new JLabel("ID gamer:");
		p.add(lblIDGame);

		txtIDGamer = new JTextField("", 10);
		p.add(txtIDGamer);

		JLabel lblNickName = new JLabel("NickName:");
		p.add(lblNickName);

		txtNickname = new JTextField("", 10);
		p.add(txtNickname);

		

		btnSave = new JButton("Save");
		p.add(btnSave);
		// TODO COLOCAR LOS LABEL CORRESPONDINTES

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

	

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

}
