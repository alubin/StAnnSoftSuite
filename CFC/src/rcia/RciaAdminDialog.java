package rcia;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.MainFrame;

public class RciaAdminDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3154004677319343553L;
	private MainFrame mainGui;

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
		
		JButton closeBtn = new JButton("Close");
		
		
		setLayout(new GridLayout(4, 1));
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
		
		add(namePanel);
		add(firstNamePanel);
		add(lastNamePanel);
		add(closeBtn);

	}

}
