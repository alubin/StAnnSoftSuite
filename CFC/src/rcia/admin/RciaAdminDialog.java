package rcia.admin;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.MainFrame;
import rcia.RciaData;
import rcia.admin.panels.RciaTabbedPanel;
import database.DatabaseStore;
import database.DbResult;
import database.DbWorker;

import javax.swing.SwingConstants;

import custom.ErrorDialog;

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
		setAlwaysOnTop(true);

		JPanel NamePanel = new JPanel();
		JLabel firstNameTitle = new JLabel("First Name:");
		firstNameTitle.setHorizontalAlignment(SwingConstants.CENTER);
//		firstNameTitle.setBounds(23, 8, 74, 14);
		firstNameField = new JTextField(15);
		firstNameTitle.setLabelFor(firstNameField);
//		firstNameField.setBounds(95, 5, 170, 20);
//		firstNameField.setColumns(15);

		JLabel lastNameTitle = new JLabel("Last Name:");
		lastNameTitle.setHorizontalAlignment(SwingConstants.CENTER);
//		lastNameTitle.setBounds(23, 33, 74, 14);
		lastNameField = new JTextField(15);
		lastNameTitle.setLabelFor(lastNameField);
//		lastNameField.setBounds(95, 30, 170, 20);
//		lastNameField.setColumns(15);

		JPanel btnPanel = new JPanel();
		JButton searchNameBtn = new JButton("Search By Name");
//		searchNameBtn.setBounds(42, 11, 111, 23);
		JButton searchAllNameBtn = new JButton("Search All");
//		searchAllNameBtn.setBounds(163, 11, 102, 23);
		//JButton closeBtn = new JButton("Close");

		getContentPane().setLayout(new GridLayout(2, 1));
		setMinimumSize(new Dimension(298, 140));
		NamePanel.setLayout(new GridLayout(2,3));

		NamePanel.add(firstNameTitle);
		NamePanel.add(firstNameField);

		NamePanel.add(lastNameTitle);
		NamePanel.add(lastNameField);
		btnPanel.setLayout(new GridLayout(2,4));

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
				DbWorker dbWorker = new DbWorker();

				System.out.println("first " + firstNameField.getText() + " Last: " +  lastNameField.getText());

				//				rciaAdminPanel = new RciaAdminPanel(mainGui);
				//				rciaAdminPanel.displayData(dbWorker.retrieveRciaData(firstNameField.getText(), lastNameField.getText()));

				//System.out.println(dbWorker.retrieveRciaData(firstNameField.getText(), lastNameField.getText()));
				ArrayList<DbResult<RciaData>> dbResults = dbWorker.retrieveRciaData(firstNameField.getText(), lastNameField.getText());
				if(!dbResults.isEmpty())
				{
					RciaTabbedPanel tabbedDisplay = new RciaTabbedPanel(dbResults);
					mainGui.setPanel(tabbedDisplay);
				}
				else
				{
					JPanel noResult = new JPanel();
					noResult.add(new JLabel("There were no matching results."));
					mainGui.setPanel(noResult);
				}
				dbWorker.dbClose();
			} catch (SQLException e1) {
				new ErrorDialog(e1);
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
				DbWorker dbWorker = new DbWorker();

				//				rciaAdminPanel = new RciaAdminPanel(mainGui);
				//				rciaAdminPanel.displayData(dbWorker.retrieveRciaData("", ""));
				mainGui.setPanel(new RciaTabbedPanel(dbWorker.retrieveRciaData("", "")));

				dbWorker.dbClose();
			} catch (SQLException e1) {
				new ErrorDialog(e1);
				e1.printStackTrace();
			}

		}

	}

}
