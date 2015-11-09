package ccf;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import main.MainFrame;

import org.jdesktop.swingx.JXTable;

public class CCFAdminPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1647988074485239841L;
	private final MainFrame mainGui;
	private JXTable resultTable;
	private DefaultTableModel adminModel;

	public CCFAdminPanel(MainFrame mainGui) {
		this.mainGui = mainGui;
		setLayout(new BorderLayout());
		adminModel = new DefaultTableModel(CCFTableModel.adminColumnNames, 0);
		resultTable = new JXTable(adminModel);
		resultTable.packAll();
		add(new JScrollPane(resultTable),BorderLayout.CENTER);
		//		mainGui.setPanel(searchResultPanel);

	}

	public void displayAll()
	{
		mainGui.setPanel(this);
	}

	public void displayAll(ArrayList<CCFData> retrieveCCFData) {
		for(CCFData data: retrieveCCFData)
		{
			adminModel.addRow(new CCFFieldData(data).getObjArray());
		}
		displayAll();

	}



}
