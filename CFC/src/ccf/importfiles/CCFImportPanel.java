package ccf.importfiles;

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

import main.MainFrame;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.search.SearchFactory;

import ccf.AccessReader;
import ccf.CCFTable;
import database.DbWorker;

/**
 * This is the display panel for the CCF Table that is displayed on the Main Gui.
 * @author AL
 *
 */
public class CCFImportPanel extends JPanel{

	/**
	 *
	 */
	private static final long serialVersionUID = 4737877830412536390L;
	private final CCFTable tableValues;
	private MainFrame mainGui;

	public CCFImportPanel(AccessReader accessReader)
	{
		tableValues = accessReader.createTable();
		JXTable accessTable = tableValues.getTable();
		JScrollPane accessScroll = new JScrollPane(accessTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JPanel btnPanel = new JPanel(new GridLayout(1,3));
		JButton btnEmail = new JButton("Enter Emails");
		JButton btnSave = new JButton("Save To Database");
		JButton btnCancel = new JButton("Cancel Import");
		JButton btnFind = new JButton("Find");

		setBorder(BorderFactory.createTitledBorder("CCF Import"));
		setLayout(new BorderLayout());

		accessTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		accessTable.packAll();


		btnSave.addActionListener(new SaveActionListener());
		btnCancel.addActionListener(new CancelActionListener());
		btnFind.addActionListener(new FindActionListener());


		btnPanel.add(btnEmail);
		btnPanel.add(btnSave);
		btnPanel.add(btnCancel);
		btnPanel.add(btnFind);
		add(btnPanel, BorderLayout.NORTH);

		add(accessScroll,BorderLayout.CENTER);
	}


	public void showPanel() {
		//Display this panel on the main GUI
		tableValues.getTable().packAll();
		mainGui.setPanel(this);

	}
	
	public void saveTable()
	{
		final int dbSave;
		DbWorker dbWorker = new DbWorker();
		dbSave = dbWorker.storeCCF(tableValues.getCCFDataArrayList());
		dbWorker.dbClose();

		JPanel savePanel = new JPanel();
//		if(dbSave == 0)
//		{
			savePanel.add(new JLabel("Your Data has been saved to the database."));
//		}
//		else
//		{
//			savePanel.add(new JLabel("Your Data could not be saved. Please check the settings."));
//		}
		
		mainGui.setPanel(savePanel);
	}

	private class SaveActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			saveTable();

		}

	}

	private class CancelActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);

		}

	}

	private class FindActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			SearchFactory mySearch = new SearchFactory();
			mySearch.showFindInput(tableValues.getTable(), tableValues.getTable().getSearchable());

		}

	}

	private class EmailActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO: Open Dialog box and pass in the CCF Data to populate the drop down list.

		}

	}

	public void setMainGui(MainFrame mainGui) {
		this.mainGui = mainGui;

	}



}
