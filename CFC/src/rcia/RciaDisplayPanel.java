package rcia;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import database.DatabaseStore;
import database.DbWorker;
import main.MainFrame;

public class RciaDisplayPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 170250086962627281L;
	private MainFrame mainDisplay;
	private final RciaTable rciaTable;

	public RciaDisplayPanel(ExcelReader excelReader)
	{
		rciaTable = excelReader.createTable();
		JTable excelTable = rciaTable.getTable();
		JScrollPane excelScroll = new JScrollPane(excelTable);
		JPanel btnPanel = new JPanel(new GridLayout(1,2));
		JButton btnSave = new JButton("Save");
		JButton btnCancel = new JButton("Cancel");

		excelTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


		setBorder(BorderFactory.createTitledBorder("Rcia Results"));
		setLayout(new BorderLayout());
		
		btnSave.addActionListener(new SaveBtnActionListener());

		btnPanel.add(btnSave);
		btnPanel.add(btnCancel);

		add(btnPanel, BorderLayout.NORTH);
		add(excelScroll,BorderLayout.CENTER);
	}

	public void setMainGui(MainFrame mainGui) {
		mainDisplay = mainGui;

	}

	public void showPanel() {
		//Display this panel on the main GUI
		mainDisplay.setPanel(this);

	}

	private class SaveBtnActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			DbWorker dbWorker = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
					DatabaseStore.getUserName(), DatabaseStore.getPassword());
			dbWorker.storeRCIA(rciaTable.getRciaDataArrayList());
			dbWorker.dbClose();


		}

	}

}
