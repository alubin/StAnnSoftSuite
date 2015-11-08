package ccf;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.MainFrame;

public class CCFAdminDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4981523267433072507L;
	
	public CCFAdminDialog(MainFrame mainGui)
	{
		
		JPanel idPanel = new JPanel(new GridLayout(1,2));
		JLabel idTitle = new JLabel("Search by ID:");
		JTextField idField = new JTextField();
		JButton searchIdBtn = new JButton("Search ID");
		
		JPanel emailPanel = new JPanel(new GridLayout(1,2));
		JLabel emailTitle = new JLabel("Search by Email:");
		JTextField emailField = new JTextField();
		JButton searchEmailBtn = new JButton("Search Email");
		
		JButton closeBtn = new JButton("Close");
		
		setLayout(new GridLayout(3,1));
		setSize(500, 100);
		
		idPanel.add(idTitle);
		idPanel.add(idField);
		idPanel.add(searchIdBtn);
		
		emailPanel.add(emailTitle);
		emailPanel.add(emailField);
		emailPanel.add(searchEmailBtn);
		
		add(idPanel);
		add(emailPanel);
		add(closeBtn);
		
	}

}
