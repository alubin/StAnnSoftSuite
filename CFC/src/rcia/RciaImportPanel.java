package rcia;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.search.SearchFactory;

import database.DatabaseStore;
import database.DbWorker;
import main.MainFrame;

public class RciaImportPanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 170250086962627281L;
	private MainFrame mainDisplay;
	private final RciaTable rciaTable;

	public RciaImportPanel(ExcelReader excelReader)
	{
		rciaTable = excelReader.createTable();
		JXTable excelTable = rciaTable.getTable();
		JScrollPane excelScroll = new JScrollPane(excelTable);
		JPanel btnPanel = new JPanel(new GridLayout(1,3));
		JButton btnSave = new JButton("Save");
		JButton btnCancel = new JButton("Cancel");
		JButton btnSearch = new JButton("Search");

		excelTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		excelTable.packAll();

		setBorder(BorderFactory.createTitledBorder("Rcia Import"));
		setLayout(new BorderLayout());

		btnSave.addActionListener(new SaveBtnActionListener());
		btnSearch.addActionListener(new FindActionListener());

		btnPanel.add(btnSave);
		btnPanel.add(btnCancel);
		btnPanel.add(btnSearch);

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

			JPanel savePanel = new JPanel();
			savePanel.add(new JLabel("Your Data has been saved to the database."));
			mainDisplay.setPanel(savePanel);

		}

	}
	
	private class FindActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			SearchFactory mySearch = new SearchFactory();
			mySearch.showFindInput(rciaTable.getTable(), rciaTable.getTable().getSearchable());

		}
		
	}

}
