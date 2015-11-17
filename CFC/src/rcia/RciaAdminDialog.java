package rcia;

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
		
		JPanel NamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5,5));
		JLabel firstNameTitle = new JLabel("First Name:");
		firstNameField = new JTextField();
		firstNameField.setColumns(15);

		JLabel lastNameTitle = new JLabel("Last Name:");
		lastNameField = new JTextField();
		lastNameField.setColumns(15);

		JPanel btnPanel = new JPanel(new FlowLayout());
		JButton searchNameBtn = new JButton("Search Name");
		JButton searchAllNameBtn = new JButton("Search All");
		//JButton closeBtn = new JButton("Close");

		setLayout(new GridLayout(5, 1));
		setSize(320, 285);

		NamePanel.add(firstNameTitle);
		NamePanel.add(firstNameField);

		NamePanel.add(lastNameTitle);
		NamePanel.add(lastNameField);
		
		btnPanel.add(searchNameBtn);
		btnPanel.add(searchAllNameBtn);
		
		searchNameBtn.addActionListener(new SearchNameListener());
		searchAllNameBtn.addActionListener(new AllListener());
		//closeBtn.addActionListener(new CloseListener());
		
		add(NamePanel);
		add(btnPanel);
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
				rciaAdminPanel.displayData(dbWorker.retrieveRciaData(firstNameField.getText(), lastNameField.getText()));

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
