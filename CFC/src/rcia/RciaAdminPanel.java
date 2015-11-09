package rcia;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import main.MainFrame;

import org.jdesktop.swingx.JXTable;

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
//		searchResultPanel = new JPanel(new BorderLayout());
		adminModel = new DefaultTableModel(RciaTableModel.columnNames, 0);
		resultTable = new JXTable(adminModel);
		resultTable.packAll();
		setLayout(new BorderLayout());
		add(new JScrollPane(resultTable),BorderLayout.CENTER);
//		mainGui.setPanel(searchResultPanel);

	}

	public void displayAll() {
		mainGui.setPanel(this);

	}
	public void displayAll(ArrayList<RciaData> retrieveRciaData) {
		displayAll();

	}

}
