package ccf;

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

import main.MainFrame;

import org.jdesktop.swingx.JXTable;

public class CCFAdminPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1647988074485239841L;
	private final MainFrame mainGui;
	private JXTable resultTable;
	private CCFAdminTableModel adminModel;

	public CCFAdminPanel(MainFrame mainGui) {
		this.mainGui = mainGui;

		JPanel btnPanel = new JPanel(new GridLayout(1,2));
		JButton btnSave = new JButton("Save Changes");
		JButton btnCancel = new JButton("Cancel Edit");

		setBorder(BorderFactory.createTitledBorder("CCF Admin"));
		setLayout(new BorderLayout());

		btnPanel.add(btnSave);
		btnPanel.add(btnCancel);

		adminModel = new CCFAdminTableModel(CCFAdminTableModel.adminColumnNames, 0);
		resultTable = new JXTable(adminModel);
		resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		resultTable.packAll();

		add(btnPanel, BorderLayout.NORTH);
		add(new JScrollPane(resultTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.CENTER);
		//		mainGui.setPanel(searchResultPanel);

	}

	public void displayAll()
	{
		mainGui.setPanel(this);
	}

	public void displayAll(ArrayList<CCFData> retrieveCCFData) {
		for(CCFData data: retrieveCCFData)
		{
			adminModel.addRow(new CCFAdminFieldData(data).getObjArray());
		}
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
