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

import database.DatabaseStore;
import database.DbWorker;
import main.MainFrame;

public class RciaAdminDialog extends JDialog {

	/**
	 *
	 */
	private static final long serialVersionUID = -3154004677319343553L;
	private MainFrame mainGui;
	private RciaAdminPanel rciaAdminPanel;

	public RciaAdminDialog(MainFrame mainGui)
	{
		this.mainGui = mainGui;
		JPanel namePanel = new JPanel(new GridLayout(1,2));
		JLabel nameTitle = new JLabel("Search by Full Name:");
		JTextField nameField = new JTextField();
		JButton searchNameBtn = new JButton("Search Full Name");

		JPanel firstNamePanel = new JPanel(new GridLayout(1,2));
		JLabel firstNameTitle = new JLabel("Search by First Name:");
		JTextField firstNameField = new JTextField();
		JButton searchFirstNameBtn = new JButton("Search First Name");

		JPanel lastNamePanel = new JPanel(new GridLayout(1,2));
		JLabel lastNameTitle = new JLabel("Search by Last Name:");
		JTextField lastNameField = new JTextField();
		JButton searchLastNameBtn = new JButton("Search Last Name");

		JButton allBtn = new JButton("Return all values");
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

		allBtn.addActionListener(new AllFieldListener());
		closeBtn.addActionListener(new CloseListener());

		add(namePanel);
		add(firstNamePanel);
		add(lastNamePanel);
		add(allBtn);
		add(closeBtn);

	}

	private class CloseListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);

		}

	}

	private class AllFieldListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				DbWorker dbWorker = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
						DatabaseStore.getUserName(), DatabaseStore.getPassword());


				rciaAdminPanel.displayAll(dbWorker.retrieveRciaData());

				dbWorker.dbClose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}
