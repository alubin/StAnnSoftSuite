package ccf;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.MainFrame;

public class CCFAdminPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1647988074485239841L;
	private final MainFrame mainGui;
	private final JPanel searchResultPanel;
	private JTable resultTable;
	private DefaultTableModel adminModel;

	public CCFAdminPanel(MainFrame mainGui) {
		this.mainGui = mainGui;
		searchResultPanel = new JPanel(new BorderLayout());
		adminModel = new DefaultTableModel(CCFTableModel.columnNames, 0);
		resultTable = new JTable(adminModel);
		searchResultPanel.add(new JScrollPane(resultTable),BorderLayout.CENTER);
//		mainGui.setPanel(searchResultPanel);
		
	}

	public void displayAll()
	{
		mainGui.setPanel(searchResultPanel);
	}



}
