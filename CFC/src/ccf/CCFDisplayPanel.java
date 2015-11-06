package ccf;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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
	private final CCFTable tableValues;
	private MainFrame mainGui;

	public CCFDisplayPanel(AccessReader accessReader)
	{
		tableValues = accessReader.createTable();
		JTable accessTable = tableValues.getTable();
		JScrollPane accessScroll = new JScrollPane(accessTable);
		JPanel btnPanel = new JPanel(new GridLayout(1,2));
		JButton btnSave = new JButton("Save");
		JButton btnCancel = new JButton("Cancel");

		setBorder(BorderFactory.createTitledBorder("CCF Results"));
		setLayout(new BorderLayout());

//		accessTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		accessTable.setPreferredScrollableViewportSize(Toolkit.getDefaultToolkit().getScreenSize());


		btnSave.addActionListener(new SaveActionListener());
		btnCancel.addActionListener(new CancelActionListener());

		btnPanel.add(btnSave);
		btnPanel.add(btnCancel);
		add(btnPanel, BorderLayout.NORTH);

		add(accessScroll,BorderLayout.CENTER);
	}


	public void showPanel() {
		//Display this panel on the main GUI
		mainGui.setPanel(this);

	}

	private class SaveActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			DbWorker dbWorker = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort());
			dbWorker.storeCCF(tableValues.getCCFDataArrayList());
			dbWorker.dbClose();
//			JPanel savePanel = new JPanel(new BorderLayout());
//			add(new JLabel("Saved!"));
//			mainGui.setPanel(savePanel);

		}

	}

	private class CancelActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);

		}

	}

	public void setMainGui(MainFrame mainGui) {
		this.mainGui = mainGui;

	}



}
