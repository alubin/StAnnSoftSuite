package rcia.admin;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.MainFrame;
import database.DatabaseStore;
import database.DbWorker;
import database.QueryType;

public class RciaAdminDialog extends JDialog {

	/**
	 *
	 */
	private static final long serialVersionUID = -3154004677319343553L;
	private final MainFrame mainGui;
	private RciaAdminPanel rciaAdminPanel;
	private JTextField firstNameField;
	private JTextField lastNameField;

	public RciaAdminDialog(MainFrame mainGui)
	{	
		this.mainGui = mainGui;
		
		setResizable(false);
		
		JPanel NamePanel = new JPanel();
		JLabel firstNameTitle = new JLabel("First Name:");
		firstNameTitle.setBounds(23, 8, 74, 14);
		firstNameField = new JTextField();
		firstNameField.setBounds(95, 5, 170, 20);
		firstNameField.setColumns(15);

		JLabel lastNameTitle = new JLabel("Last Name:");
		lastNameTitle.setBounds(23, 33, 74, 14);
		lastNameField = new JTextField();
		lastNameField.setBounds(95, 30, 170, 20);
		lastNameField.setColumns(15);

		JPanel btnPanel = new JPanel();
		JButton searchNameBtn = new JButton("Search Name");
		searchNameBtn.setBounds(42, 11, 111, 23);
		JButton searchAllNameBtn = new JButton("Search All");
		searchAllNameBtn.setBounds(163, 11, 102, 23);
		//JButton closeBtn = new JButton("Close");

		getContentPane().setLayout(new GridLayout(2, 1));
		setSize(298, 140);
		NamePanel.setLayout(null);

		NamePanel.add(firstNameTitle);
		NamePanel.add(firstNameField);

		NamePanel.add(lastNameTitle);
		NamePanel.add(lastNameField);
		btnPanel.setLayout(null);
		
		btnPanel.add(searchNameBtn);
		btnPanel.add(searchAllNameBtn);
		
		searchNameBtn.addActionListener(new SearchNameListener());
		searchAllNameBtn.addActionListener(new AllListener());
		//closeBtn.addActionListener(new CloseListener());
		
		getContentPane().add(NamePanel);
		getContentPane().add(btnPanel);
		//add(closeBtn);

	}

	private class SearchNameListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0){

			try {
				DbWorker dbWorker = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
						DatabaseStore.getUserName(), DatabaseStore.getPassword());

				rciaAdminPanel = new RciaAdminPanel(mainGui);
//				rciaAdminPanel.displayData(dbWorker.retrieveRciaData(firstNameField.getText(), lastNameField.getText()));

				System.out.println(dbWorker.retrieveRciaData(firstNameField.getText(), lastNameField.getText()));
				dbWorker.dbClose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private class CloseListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);

		}

	}

	private class AllListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				DbWorker dbWorker = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
						DatabaseStore.getUserName(), DatabaseStore.getPassword());

				rciaAdminPanel = new RciaAdminPanel(mainGui);
				rciaAdminPanel.displayData(dbWorker.retrieveRciaData("", ""));

				dbWorker.dbClose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}