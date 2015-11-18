package ccf;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.search.SearchFactory;

import main.MainFrame;
import database.DatabaseStore;
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

	private class SaveActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			DbWorker dbWorker = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
					DatabaseStore.getUserName(), DatabaseStore.getPassword());
			dbWorker.storeCCF(tableValues.getCCFDataArrayList());
			dbWorker.dbClose();

			JPanel savePanel = new JPanel();
			savePanel.add(new JLabel("Your Data has been saved to the database."));
			mainGui.setPanel(savePanel);

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
