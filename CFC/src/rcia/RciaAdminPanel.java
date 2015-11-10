package rcia;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.MainFrame;

import org.jdesktop.swingx.JXTable;

import ccf.CCFData;
import ccf.CCFFieldData;

public class RciaAdminPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1233345764207263629L;
	private final MainFrame mainGui;
//	private final JPanel searchResultPanel;
	private JXTable resultTable;
	private DefaultTableModel adminModel;

	public RciaAdminPanel(MainFrame mainGui) {
		this.mainGui = mainGui;
		
		JPanel btnPanel = new JPanel(new GridLayout(1,2));
		JButton btnSave = new JButton("Save Changes");
		JButton btnCancel = new JButton("Cancel Edit");
		
		btnSave.addActionListener(new SaveActionListener());
		btnCancel.addActionListener(new CloseActionListener());
		btnPanel.add(btnSave);
		btnPanel.add(btnCancel);
		
//		searchResultPanel = new JPanel(new BorderLayout());
		adminModel = new DefaultTableModel(RciaTableModel.columnNames, 0);
		resultTable = new JXTable(adminModel);
		resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		setBorder(BorderFactory.createTitledBorder("Rcia Admin"));
		setLayout(new BorderLayout());
		add(btnPanel, BorderLayout.NORTH);
		add(new JScrollPane(resultTable),BorderLayout.CENTER);
//		mainGui.setPanel(searchResultPanel);

	}

	public void displayAll() {
		mainGui.setPanel(this);

	}
	public void displayAll(ArrayList<RciaData> retrieveRciaData) {
		for(RciaData data: retrieveRciaData)
		{
			adminModel.addRow(data.getArray().toArray());
		}
		resultTable.packAll();
		displayAll();

	}
	
	public class SaveActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Saving Changes");
//			adminModel.ge
			
		}
		
	}
	
	public class CloseActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			
		}
		
	}

}
