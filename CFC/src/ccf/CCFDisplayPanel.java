package ccf;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.MainFrame;

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
		JButton btnCancel = new JButton("Cancel");
		btnPanel.add(btnSave);
		btnPanel.add(btnCancel);
		add(btnPanel, BorderLayout.NORTH);
		
		add(new JScrollPane(accessTable),BorderLayout.CENTER);
	}


	public void displayPanel(MainFrame mainGui) {
		//Display this panel on the main GUI
		mainGui.setPanel(this);
		
	}



}
