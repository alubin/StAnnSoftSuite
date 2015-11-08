package rcia;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RciaAdminDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3154004677319343553L;

	public RciaAdminDialog()
	{
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
		
		JPanel idPanel = new JPanel(new GridLayout(1,2));
		JLabel idTitle = new JLabel("Search by ID:");
		JTextField idField = new JTextField();
		JButton searchIdBtn = new JButton("Search ID");
		
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
		
		idPanel.add(idTitle);
		idPanel.add(idField);
		idPanel.add(searchIdBtn);
		
		add(namePanel);
		add(firstNamePanel);
		add(lastNamePanel);
		add(idPanel);
	}

}
