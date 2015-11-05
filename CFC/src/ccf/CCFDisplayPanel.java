package ccf;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import main.MainDisplayPanel;

public class CCFDisplayPanel extends JPanel{

	/**
	 *
	 */
	private static final long serialVersionUID = 4737877830412536390L;

	public CCFDisplayPanel(AccessReader accessReader)
	{
		JTable accessTable = accessReader.createTable();
		setLayout(new BorderLayout());
		JPanel btnPanel = new JPanel(new GridLayout(1,2));
		JButton btnSave = new JButton("Save");
		btnPanel.add(btnSave);
		add(btnPanel, BorderLayout.NORTH);
		add(accessTable);
	}

	public void displayPanel()
	{
		//Display this panel on the main GUI
		JPanel testPanel = new JPanel(new GridLayout());
		testPanel.add(new JButton("Help"));
		MainDisplayPanel.setPanel(testPanel);
//		MainDisplayPanel.setPanel(this);
	}



}
