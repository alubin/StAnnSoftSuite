package ccf;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import main.MainFrame;
import database.DatabaseStore;
import database.DbWorker;
import database.QueryType;

public class CCFAdminDialog extends JDialog {

	/**
	 *
	 */
	private static final long serialVersionUID = 4981523267433072507L;

	private CCFAdminPanel adminPanel;
	private  MainFrame mainGui;
	private CCFEmailDialog emailDialog;

	public CCFAdminDialog(MainFrame mainGui)
	{
		emailDialog = new CCFEmailDialog(new ArrayList<CCFData>());
		JPanel idPanel = new JPanel(new GridLayout(1,2));
		JLabel idTitle = new JLabel("Search by ID:");
		JTextField idField = new JTextField();
		JButton searchIdBtn = new JButton("Search ID");

		JPanel emailPanel = new JPanel(new GridLayout(1,2));
		JLabel emailTitle = new JLabel("Search by Email:");
		JTextField emailField = new JTextField();
		JButton searchEmailBtn = new JButton("Search Email");

		JButton allBtn = new JButton("Get All Values");
		JButton closeBtn = new JButton("Close");

		setLayout(new GridLayout(4,1));
		setSize(500, 150);

		closeBtn.addActionListener(new CloseActionListener());
		allBtn.addActionListener(new AllActionListener());

		idPanel.add(idTitle);
		idPanel.add(idField);
		idPanel.add(searchIdBtn);

		emailPanel.add(emailTitle);
		emailPanel.add(emailField);
		emailPanel.add(searchEmailBtn);

		add(idPanel);
		add(emailPanel);
		add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);
		add(emailDialog);
		add(allBtn);
		add(closeBtn);

	}

	private class CloseActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}

	private class AllActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO: Get fields from database.
			try {
				DbWorker dbWorker = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
						DatabaseStore.getUserName(), DatabaseStore.getPassword());
				adminPanel = new CCFAdminPanel(mainGui);
				adminPanel.displayAll(dbWorker.retrieveCCFData(QueryType.all, ""));
				dbWorker.dbClose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			adminPanel.displayAll();
		}

	}

}
