package ccf;

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
		JPanel btnPanel = new JPanel(new GridLayout(1,2));
		JButton btnSave = new JButton("Save To Database");
		JButton btnCancel = new JButton("Cancel Import");

		setBorder(BorderFactory.createTitledBorder("CCF Import"));
		setLayout(new BorderLayout());

		accessTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		accessTable.packAll();


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
			// TODO Auto-generated method stub
//			(tableValues.getTable()).
		}
		
	}

	public void setMainGui(MainFrame mainGui) {
		this.mainGui = mainGui;

	}



}
