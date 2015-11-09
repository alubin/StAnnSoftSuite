package ccf;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	private CCFAdminPanel adminPanel;
	
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
		
		JButton allBtn = new JButton("Get All Values");
		JButton closeBtn = new JButton("Close");
		
		adminPanel = new CCFAdminPanel(mainGui);
		
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
			System.out.println("Yikes!");
			adminPanel.displayAll();
		}
		
	}

}
