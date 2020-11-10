package view;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class Table extends JPanel {
	private JTable table;

	public Table() {

		String[] columnas = { "NickN Name ", "ID", "New column" };

		DefaultTableModel dfModel = new DefaultTableModel(null, columnas);

		table = new JTable();
		table.setModel(dfModel);
		add(table);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
