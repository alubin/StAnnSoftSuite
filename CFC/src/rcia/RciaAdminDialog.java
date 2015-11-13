package rcia;

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
		JPanel namePanel = new JPanel(new GridLayout(1,2));
		JLabel nameTitle = new JLabel("Search by Full Name:");
		JTextField nameField = new JTextField();
		JButton searchNameBtn = new JButton("Search Full Name");

		JPanel firstNamePanel = new JPanel(new GridLayout(1,2));
		JLabel firstNameTitle = new JLabel("Search by First Name:");
		firstNameField = new JTextField();
		JButton searchFirstNameBtn = new JButton("Search First Name");

		JPanel lastNamePanel = new JPanel(new GridLayout(1,2));
		JLabel lastNameTitle = new JLabel("Search by Last Name:");
		lastNameField = new JTextField();
		JButton searchLastNameBtn = new JButton("Search Last Name");

		JButton searchFullNameBtn = new JButton("Return all values");
		JButton closeBtn = new JButton("Close");

		rciaAdminPanel = new RciaAdminPanel(mainGui);


		setLayout(new GridLayout(5, 1));
		setSize(600, 150);

		namePanel.add(nameTitle);
		namePanel.add(nameField);
		namePanel.add(searchNameBtn);

		firstNamePanel.add(firstNameTitle);
		firstNamePanel.add(firstNameField);
		firstNamePanel.add(searchFirstNameBtn);

		lastNamePanel.add(lastNameTitle);
		lastNamePanel.add(lastNameField);
		lastNamePanel.add(searchLastNameBtn);

		searchFirstNameBtn.addActionListener(new FirstListener());
		searchLastNameBtn.addActionListener(new LastListener());
		searchFullNameBtn.addActionListener(new FullListener());
		closeBtn.addActionListener(new CloseListener());

		add(namePanel);
		add(firstNamePanel);
		add(lastNamePanel);
		add(searchFullNameBtn);
		add(closeBtn);

	}

	private class FirstListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0){

			try {
				DbWorker dbWorker = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
						DatabaseStore.getUserName(), DatabaseStore.getPassword());

				rciaAdminPanel.displayAll(dbWorker.retrieveRciaData(QueryType.rciaFName, firstNameField.getText()));

				dbWorker.dbClose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private class LastListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0){

			try {
				DbWorker dbWorker = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
						DatabaseStore.getUserName(), DatabaseStore.getPassword());

				rciaAdminPanel.displayAll(dbWorker.retrieveRciaData(QueryType.rciaLName, lastNameField.getText()));

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

	private class FullListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				DbWorker dbWorker = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
						DatabaseStore.getUserName(), DatabaseStore.getPassword());


				rciaAdminPanel.displayAll(dbWorker.retrieveRciaData(QueryType.rciaFull, ""));

				dbWorker.dbClose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//			rciaAdminPanel.displayAll();

		}

	}

	private class AllListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				DbWorker dbWorker = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
						DatabaseStore.getUserName(), DatabaseStore.getPassword());


				rciaAdminPanel.displayAll(dbWorker.retrieveRciaData(QueryType.all, ""));

				dbWorker.dbClose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}
