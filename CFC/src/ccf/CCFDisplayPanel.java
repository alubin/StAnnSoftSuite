package ccf;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.MainFrame;
import database.DatabaseStore;
import database.DbWorker;

public class CCFDisplayPanel extends JPanel{

	/**
	 *
	 */
	private static final long serialVersionUID = 4737877830412536390L;
	CCFTable tableValues;

	public CCFDisplayPanel(AccessReader accessReader)
	{
		tableValues = accessReader.createTable();
		JTable accessTable = tableValues.getTable();
		setLayout(new BorderLayout());
		JPanel btnPanel = new JPanel(new GridLayout(1,2));
		JButton btnSave = new JButton("Save");
		JButton btnCancel = new JButton("Cancel");

		btnSave.addActionListener(new saveActionListener());

		btnPanel.add(btnSave);
		btnPanel.add(btnCancel);
		add(btnPanel, BorderLayout.NORTH);

		add(new JScrollPane(accessTable),BorderLayout.CENTER);
	}


	public void displayPanel(MainFrame mainGui) {
		//Display this panel on the main GUI
		mainGui.setPanel(this);

	}

	private class saveActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			DbWorker dbWorker = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort());
			dbWorker.storeCCF(tableValues.getCCFDataArrayList());
			dbWorker.dbClose();
//			JPanel savePanel = new JPanel(new BorderLayout());
//			add(new JLabel("Saved!"));
//			mainGui.

		}

	}



}
