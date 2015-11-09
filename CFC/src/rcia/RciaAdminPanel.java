package rcia;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXTable;

import main.MainFrame;

public class RciaAdminPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1233345764207263629L;
	private final MainFrame mainGui;
	private final JPanel searchResultPanel;
	private JXTable resultTable;
	private DefaultTableModel adminModel;

	public RciaAdminPanel(MainFrame mainGui) {
		this.mainGui = mainGui;
		searchResultPanel = new JPanel(new BorderLayout());
		adminModel = new DefaultTableModel(RciaTableModel.columnNames, 0);
		resultTable = new JXTable(adminModel);
		resultTable.packAll();
		searchResultPanel.add(new JScrollPane(resultTable),BorderLayout.CENTER);
//		mainGui.setPanel(searchResultPanel);

	}

	public void displayAll(ArrayList<RciaData> retrieveRciaData) {
		mainGui.setPanel(searchResultPanel);

	}

}
