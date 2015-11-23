package ccf;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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
		emailDialog.disableDialog(true);
		JPanel searchPanel = new JPanel(new GridLayout(2,1));
		JPanel emailSettingPanel = new JPanel(new GridLayout(1,3));

		JPanel idPanel = new JPanel(new GridLayout(3,1));
		JLabel idTitle = new JLabel("Search by ID:");
		JTextField idField = new JTextField();
		JButton searchIdBtn = new JButton("Search ID");

		JPanel emailPanel = new JPanel(new GridLayout(3,1));
		JLabel emailTitle = new JLabel("Search by Email:");
		JTextField emailField = new JTextField();
		JButton searchEmailBtn = new JButton("Search Email");

		JButton allBtn = new JButton("Get All Students");
		JButton closeBtn = new JButton("Close");

		JPanel btnPanel = new JPanel(new GridLayout(4,1));


		setLayout(new GridLayout(3,1));

		setSize(500, 400);



		idPanel.add(idTitle);
		idPanel.add(idField);
		idPanel.add(searchIdBtn);

		emailPanel.add(emailTitle);
		emailPanel.add(emailField);
		emailPanel.add(searchEmailBtn);

		searchPanel.add(idPanel);
		searchPanel.add(emailPanel);

		emailSettingPanel.add(emailDialog);

		btnPanel.add(new JLabel());
		btnPanel.add(allBtn);
		btnPanel.add(closeBtn);

		closeBtn.addActionListener(new CloseActionListener());
		allBtn.addActionListener(new AllActionListener());
		searchIdBtn.addActionListener(new IdSubmitActionlistener());
		searchEmailBtn.addActionListener(new EmailSubmitActionlistener());

		add(searchPanel);
		add(emailSettingPanel);
		add(btnPanel);

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
	
	private class EmailSubmitActionlistener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class IdSubmitActionlistener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	

}
