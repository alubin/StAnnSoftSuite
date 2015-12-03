package rcia.admin;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class UpdateDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel message;

	public UpdateDialog(String name)
	{
		setSize(400,200);
		setLocationRelativeTo(null);
		message = new JLabel("The information for "+ name +" has been changed.");
		add(message);
	}
	
	public UpdateDialog()
	{
		setSize(400,200);
		setLocationRelativeTo(null);
		message = new JLabel("The information has been changed.");
		
		add(message);
	}
	
	

}
